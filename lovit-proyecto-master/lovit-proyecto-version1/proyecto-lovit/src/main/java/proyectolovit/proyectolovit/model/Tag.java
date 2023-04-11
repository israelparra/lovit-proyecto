package proyectolovit.proyectolovit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Tag {

    @Id
    @Column(name = "id_tag")
    private int id;

    @NotBlank
    private String nombre;

    public Tag() {
    }

    public Tag(@NotBlank String nombre) {
        this.nombre = nombre;
    }

    public Tag(int id, @NotBlank String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
