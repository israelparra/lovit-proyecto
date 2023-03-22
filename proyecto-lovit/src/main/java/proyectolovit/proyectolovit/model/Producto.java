package proyectolovit.proyectolovit.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

public class Producto {

    private long id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String descripcion;

    @NotNull
    private float precio;

    @NotNull
    private int minimoCompra;

    @NotNull
    private float alto;

    @NotNull
    private float ancho;

    @NotNull
    private float peso;

    @NotBlank
    private Tag tags;

    @NotBlank
    private Imagen imagenPortada;

    @NotEmpty
    private ArrayList<Imagen> imagenesAdicionales;

    @NotEmpty
    private ArrayList<InsumoProducto> insumosReq;

    public Producto() {
    }

    public Producto(long id, @NotBlank String nombre, @NotBlank String descripcion, @NotNull float precio,
                    @NotNull int minimoCompra, @NotNull float alto, @NotNull float ancho, @NotNull float peso,
                    @NotBlank Tag tags, @NotBlank Imagen imagenPortada, @NotEmpty ArrayList<Imagen> imagenesAdicionales,
                    @NotEmpty ArrayList<InsumoProducto> insumosReq) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.minimoCompra = minimoCompra;
        this.alto = alto;
        this.ancho = ancho;
        this.peso = peso;
        this.tags = tags;
        this.imagenPortada = imagenPortada;
        this.imagenesAdicionales = imagenesAdicionales;
        this.insumosReq = insumosReq;
    }

    public Producto(@NotBlank String nombre, @NotBlank String descripcion, @NotNull float precio,
                    @NotNull int minimoCompra, @NotNull float alto, @NotNull float ancho, @NotNull float peso,
                    @NotBlank Tag tags, @NotBlank Imagen imagenPortada, @NotEmpty ArrayList<Imagen> imagenesAdicionales,
                    @NotEmpty ArrayList<InsumoProducto> insumosReq) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.minimoCompra = minimoCompra;
        this.alto = alto;
        this.ancho = ancho;
        this.peso = peso;
        this.tags = tags;
        this.imagenPortada = imagenPortada;
        this.imagenesAdicionales = imagenesAdicionales;
        this.insumosReq = insumosReq;
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

    public String getDescripcion() {
        return descripcion;
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

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Tag getTags() {
        return tags;
    }

    public void setTags(Tag tags) {
        this.tags = tags;
    }

    public Imagen getImagenPortada() {
        return imagenPortada;
    }

    public void setImagenPortada(Imagen imagenPortada) {
        this.imagenPortada = imagenPortada;
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

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", minimoCompra=" + minimoCompra +
                ", alto=" + alto +
                ", ancho=" + ancho +
                ", peso=" + peso +
                ", tags=" + tags +
                ", imagenPortada=" + imagenPortada +
                ", imagenesAdicionales=" + imagenesAdicionales +
                ", insumosReq=" + insumosReq +
                '}';
    }
}
