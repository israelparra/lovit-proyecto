package proyectolovit.proyectolovit.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

public class Imagen {

    @NotBlank
    private String URL;

    public Imagen() {
    }

    public Imagen(@NotBlank String URL) {
        this.URL = URL;
    }

    public String getURL() {
        return URL;
    }

    @Transient
    private MultipartFile portada;

    private String rutaPortada;

    public String getRutaPortada() {
        return rutaPortada;
    }

    public void setRutaPortada(String rutaPortada) {
        this.rutaPortada = rutaPortada;
    }

    public MultipartFile getPortada() {
        return portada;
    }

    public void setPortada(MultipartFile portada) {
        this.portada = portada;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
