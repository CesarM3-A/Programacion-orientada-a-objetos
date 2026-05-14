package proyectobibliopoo;

public class Usuario extends Persona {
    private String idEstudiante;
    private int librosPrestados = 0;
    private boolean multaPendiente = false;
    private double montoMulta = 0.0;

    public Usuario(String nombre, String apellido, String cedula, String idEstudiante) {
        super(nombre, apellido, cedula);
        this.idEstudiante = idEstudiante;
    }

    public boolean puedePedirLibro() {
        return librosPrestados < 3 && !multaPendiente; // R2 y R3
    }

    public void incrementarLibros() { this.librosPrestados++; }
    public void decrementarLibros() { if(librosPrestados > 0) this.librosPrestados--; }

    public void setMulta(double monto) {
        if (monto > 0) {
            this.multaPendiente = true;
            this.montoMulta += monto;
        }
    }

    public double getMontoMulta() { return montoMulta; }

    @Override
    public void mostrarInformacion() {
        System.out.println("Usuario: " + nombre + " " + apellido + " | ID: " + idEstudiante);
    }

    public boolean isMultaPendiente() { return multaPendiente; }
    public int getLibrosPrestados() { return librosPrestados; }
    public String getNombreCompleto() { return nombre + " " + apellido; }
}