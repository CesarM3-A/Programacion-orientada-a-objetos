package proyectobibliopoo;

public class Prestamo {

    private Libro libro;
    private Usuario usuario;
    private int diasPrestado;
    private boolean activo;

    public Prestamo(Libro libro, Usuario usuario, int diasPrestado) {
        this.libro = libro;
        this.usuario = usuario;
        this.diasPrestado = diasPrestado;
        this.activo = true;
    }

    // R6: Multa de $0.50 por cada día de retraso si supera los 7 días
    public double calcularMulta() {
        if (diasPrestado > 7) {
            return (diasPrestado - 7) * 0.50;
        }
        return 0.0;
    }

    public void cerrarPrestamo() {
        double multa = calcularMulta(); // R6: Calcula basado en los días 
        if (multa > 0) {
            usuario.setMulta(multa);
            // AGREGAR ESTA LÍNEA:
            System.out.println("¡AVISO!: El libro '" + libro.getTitulo() + "' tiene un retraso. Multa generada: $" + multa);
        } else {
            System.out.println("Devolución del libro '" + libro.getTitulo() + "' realizada a tiempo.");
        }
        libro.devolver();
        usuario.decrementarLibros();
        this.activo = false;
    }

    public Libro getLibro() {
        return libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public boolean isActivo() {
        return activo;
    }
}
