package proyectolovit.proyectolovit.model;

public class Administrador extends Usuario{

    public Administrador(String usuario, String contrasenia) {
        super(usuario, contrasenia);
    }

    public Administrador(long id, String usuario, String contrasenia) {
        super(id, usuario, contrasenia);
    }
}
