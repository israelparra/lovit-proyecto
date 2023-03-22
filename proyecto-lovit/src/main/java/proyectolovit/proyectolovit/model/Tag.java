package proyectolovit.proyectolovit.model;

import javax.validation.constraints.NotBlank;

public class Tag {

    private long id;

    @NotBlank
    private String nombre;

    public Tag(@NotBlank String nombre) {
        this.nombre = nombre;
    }

    public Tag(long id, @NotBlank String nombre) {
        this.id = id;
        this.nombre = nombre;
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
}
