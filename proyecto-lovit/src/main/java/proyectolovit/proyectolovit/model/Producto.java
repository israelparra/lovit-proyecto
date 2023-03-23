package proyectolovit.proyectolovit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private int id;

    private String nombre;

    private String descripcion;

    private float precio;

    private int minimoCompra;

    private float alto;

    private float ancho;

    private float peso;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="tag_producto", joinColumns = @JoinColumn(name="id_producto"),inverseJoinColumns = @JoinColumn(name = "id_tag"))
    private List<Tag> tags;

    private String imagenRuta;

    @Transient
    private MultipartFile portada;

    private ArrayList<Imagen> imagenesAdicionales;

    private ArrayList<InsumoProducto> insumosReq;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getMinimoCompra() {
        return minimoCompra;
    }

    public void setMinimoCompra(int minimoCompra) {
        this.minimoCompra = minimoCompra;
    }

    public float getAlto() {
        return alto;
    }

    public void setAlto(float alto) {
        this.alto = alto;
    }

    public float getAncho() {
        return ancho;
    }

    public String getImagenRuta() {
        return imagenRuta;
    }

    public void setImagenRuta(String imagenRuta) {
        this.imagenRuta = imagenRuta;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    public ArrayList<Imagen> getImagenesAdicionales() {
        return imagenesAdicionales;
    }

    public void setImagenesAdicionales(ArrayList<Imagen> imagenesAdicionales) {
        this.imagenesAdicionales = imagenesAdicionales;
    }

    public ArrayList<InsumoProducto> getInsumosReq() {
        return insumosReq;
    }

    public void setInsumosReq(ArrayList<InsumoProducto> insumosReq) {
        this.insumosReq = insumosReq;
    }

    public MultipartFile getPortada() {
        return portada;
    }

    public void setPortada(MultipartFile portada) {
        this.portada = portada;
    }
}
