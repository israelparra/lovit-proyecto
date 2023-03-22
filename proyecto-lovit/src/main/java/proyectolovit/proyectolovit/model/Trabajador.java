package proyectolovit.proyectolovit.model;

public class Trabajador extends Usuario{

    public Trabajador(String usuario, String contrasenia) {
        super(usuario, contrasenia);
    }

    public Trabajador(long id, String usuario, String contrasenia) {
        super(id, usuario, contrasenia);
    }
}
