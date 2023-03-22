package proyectolovit.proyectolovit.model;

import javax.validation.constraints.NotBlank;

public class Usuario {

    private long id;

    @NotBlank
    private String usuario;

    @NotBlank
    private String contrasenia;

    public Usuario(@NotBlank String usuario, @NotBlank String contrasenia) {
        this.id = id;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public Usuario(long id, @NotBlank String usuario, @NotBlank String contrasenia) {
        this.id = id;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", usuario='" + usuario + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                '}';
    }
}
