package proyectolovit.proyectolovit.model;

import javax.validation.constraints.NotBlank;

public class Cliente {

    @NotBlank
    private String nombre;

    @NotBlank
    private String correo;

    @NotBlank
    private String direccion;

    @NotBlank
    private String numTelefono;

    public Cliente() {
    }

    public Cliente(@NotBlank String nombre, @NotBlank String correo, @NotBlank String direccion, @NotBlank String numTelefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.numTelefono = numTelefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", numTelefono='" + numTelefono + '\'' +
                '}';
    }
}
