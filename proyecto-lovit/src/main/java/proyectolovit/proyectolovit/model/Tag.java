package proyectolovit.proyectolovit.model;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class Tag {

    @Id
    private int id_tag;

    private String nombre;

    public Tag(int id_tag, String nombre) {
        this.id_tag = id_tag;
        this.nombre = nombre;
    }

    public int getId_tag() {
        return id_tag;
    }

    public void setId_tag(int id_tag) {
        this.id_tag = id_tag;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
