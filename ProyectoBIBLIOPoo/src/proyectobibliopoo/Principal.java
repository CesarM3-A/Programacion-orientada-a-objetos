package proyectobibliopoo;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Nombre de la biblioteca: ");
        Biblioteca biblio = new Biblioteca(entrada.nextLine());


        // 2. Registrar 8 libros por teclado 
        System.out.println("\n--- REGISTRO DE 8 LIBROS ---");
        for (int i = 1; i <= 8; i++) {
            System.out.println("Libro #" + i);
            System.out.print("Título: ");
            String titulo = entrada.nextLine();
            System.out.print("Autor: ");
            String autor = entrada.nextLine();
            System.out.print("Género (Novela, Ciencia, Historia, Fantasía): ");
            String genero = entrada.nextLine();
            biblio.registrarLibro(new Libro(titulo, autor, genero));
        }

        // 3. Registrar 3 usuarios por teclado [cite: 1, 27]
        Usuario[] usuariosTemp = new Usuario[3];
        System.out.println("\n--- REGISTRO DE 3 USUARIOS ---");
        for (int i = 0; i < 3; i++) {
            System.out.println("Usuario #" + (i + 1));
            System.out.print("Nombre: ");
            String nom = entrada.nextLine();
            System.out.print("Apellido: ");
            String ape = entrada.nextLine();
            
            String ced;
            do {
                System.out.print("Cédula (10 dígitos válidos): ");
                ced = entrada.nextLine();
                if (!ValidacionCedula.validarCedula(ced)) {
                    System.out.println("Cédula inválida. Intente de nuevo.");
                }
            } while (!ValidacionCedula.validarCedula(ced));

            System.out.print("ID Estudiante: ");
            String id = entrada.nextLine();
            
            usuariosTemp[i] = new Usuario(nom, ape, ced, id);
            biblio.registrarUsuario(usuariosTemp[i]);
        }

        // 4. Realizar 5 préstamos [cite: 1, 28]
        System.out.println("\n--- REALIZAR 5 PRÉSTAMOS ---");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Préstamo #" + i);
            System.out.print("Título del libro a buscar: ");
            String busqueda = entrada.nextLine();
            Libro libroEncontrado = biblio.buscarPorTitulo(busqueda);

            System.out.print("Cédula del usuario que solicita: ");
            String cedBusqueda = entrada.nextLine();
            Usuario usuarioEncontrado = null;
            
            // Buscar el usuario en la lista temporal para la prueba
            for(Usuario u : usuariosTemp) {
                if(u.cedula.equals(cedBusqueda)) usuarioEncontrado = u;
            }

            if (libroEncontrado != null && usuarioEncontrado != null) {
                System.out.print("Días de préstamo: ");
                int dias = Integer.parseInt(entrada.nextLine());
                biblio.realizarPrestamo(usuarioEncontrado, libroEncontrado, dias);
            } else {
                System.out.println("Error: Libro o Usuario no encontrado.");
            }
        }

        // 5. Devoluciones (Una a tiempo y una con retraso) [cite: 1, 30]
        System.out.println("\n--- REGISTRAR 2 DEVOLUCIONES ---");
        for (int i = 1; i <= 2; i++) {
            System.out.print("Título del libro a devolver: ");
            String tituloDev = entrada.nextLine();
            Libro lDev = biblio.buscarPorTitulo(tituloDev);
            
            if (lDev != null) {
                Prestamo p = biblio.obtenerPrestamoActivo(lDev);
                if (p != null) {
                    p.cerrarPrestamo();
                    System.out.println("Libro devuelto exitosamente.");
                } else {
                    System.out.println("No hay un préstamo activo para este libro.");
                }
            }
        }

        // 6. Búsqueda por género [cite: 1, 31]
        System.out.print("\nIngrese un género para buscar libros: ");
        String genBusqueda = entrada.nextLine();
        Libro[] resultados = biblio.buscarPorGenero(genBusqueda);
        System.out.println("Resultados encontrados: " + resultados.length);
        for(Libro r : resultados) System.out.println("- " + r);

        // 7. Reporte final [cite: 1, 32]
        biblio.generarReporte();
        
        entrada.close();
    }
}