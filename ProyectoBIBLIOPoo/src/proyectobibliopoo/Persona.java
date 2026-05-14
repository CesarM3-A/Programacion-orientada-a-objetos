/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectobibliopoo;

public abstract class Persona {
    protected String nombre;
    protected String apellido;
    protected String cedula;

    public Persona(String nombre, String apellido, String cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }

    // Getter necesario para Principal.java y Biblioteca.java
    public String getCedula() { return cedula; }

    public abstract void mostrarInformacion(); // R9: Polimorfismo
}