package proyectolovit.proyectolovit.model;

import javax.validation.constraints.NotBlank;

public class Proveedor {

    private long id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String empresa;

    public Proveedor(long id, @NotBlank String nombre, @NotBlank String empresa) {
        this.id = id;
        this.nombre = nombre;
        this.empresa = empresa;
    }

    public Proveedor(@NotBlank String nombre, @NotBlank String empresa) {
        this.id = id;
        this.nombre = nombre;
        this.empresa = empresa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", empresa='" + empresa + '\'' +
                '}';
    }
}
