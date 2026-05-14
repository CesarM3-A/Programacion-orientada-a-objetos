package proyectobibliopoo;

import java.util.ArrayList;

public class Biblioteca {
    private String nombre;
    private Libro[] catalogo = new Libro[20]; // R1
    private int contadorLibros = 0;
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private ArrayList<Prestamo> listaPrestamos = new ArrayList<>();

    public Biblioteca(String nombre) { this.nombre = nombre; }

    public void registrarLibro(Libro l) {
        if (contadorLibros < 20) {
            catalogo[contadorLibros++] = l;
        } else {
            System.err.println("Error: Catálogo lleno.");
        }
    }

    public void registrarUsuario(Usuario u) { listaUsuarios.add(u); }

    public void mostrarLibrosDisponibles() { // R7
        System.out.println("\n--- LIBROS DISPONIBLES ---");
        for (int i = 0; i < contadorLibros; i++) {
            if (catalogo[i].estaDisponible()) {
                System.out.println("- " + catalogo[i].getTitulo());
            }
        }
    }

    public Libro buscarPorTitulo(String titulo) { // R8
        for (int i = 0; i < contadorLibros; i++) {
            if (catalogo[i].getTitulo().equalsIgnoreCase(titulo)) return catalogo[i];
        }
        return null;
    }

    public Libro[] buscarPorGenero(String genero) { // R4
        ArrayList<Libro> encontrados = new ArrayList<>();
        for (int i = 0; i < contadorLibros; i++) {
            if (catalogo[i].getGenero().equalsIgnoreCase(genero)) encontrados.add(catalogo[i]);
        }
        return encontrados.toArray(new Libro[0]);
    }

    public void realizarPrestamo(Usuario u, Libro l, int dias) {
        if (u.puedePedirLibro() && l.estaDisponible()) {
            l.prestar();
            u.incrementarLibros();
            listaPrestamos.add(new Prestamo(l, u, dias));
            System.out.println("Préstamo exitoso.");
        } else {
            System.out.println("ERROR: Préstamo denegado.");
        }
    }

    public void generarReporte() { // R5
        System.out.println("\n--- REPORTE FINAL DE USUARIOS ---");
        for (Usuario u : listaUsuarios) {
            System.out.println("Nombre: " + u.getNombreCompleto() + 
                               " | Libros: " + u.getLibrosPrestados() + 
                               " | Multa: " + (u.isMultaPendiente() ? "$" + u.getMontoMulta() : "Ninguna"));
        }
    }

    public Prestamo obtenerPrestamoActivo(Libro l) {
        for (Prestamo p : listaPrestamos) {
            if (p.getLibro() == l && p.isActivo()) return p;
        }
        return null;
    }
}