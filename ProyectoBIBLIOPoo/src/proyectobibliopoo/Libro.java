package proyectobibliopoo;

public class Libro {
    private String titulo;
    private String autor;
    private String genero;
    private boolean disponible = true;

    public Libro(String titulo, String autor, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
    }

    public boolean estaDisponible() { return disponible; }
    public void prestar() { this.disponible = false; }
    public void devolver() { this.disponible = true; }

    public String getTitulo() { return titulo; }
    public String getGenero() { return genero; }
    
    @Override
    public String toString() {
        return "[" + genero + "] " + titulo + " - " + (disponible ? "Disponible" : "Prestado");
    }
}