package proyectolovit.proyectolovit.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Insumo {

    private long id;

    @NotBlank
    private String nombre;

    @NotNull
    private float cantidad;

    @NotBlank
    TipoInsumo tipoInsumo;

    public Insumo(@NotBlank String nombre, @NotNull float cantidad, @NotBlank TipoInsumo tipoInsumo) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipoInsumo = tipoInsumo;
    }

    public Insumo(long id, @NotBlank String nombre, @NotNull float cantidad, @NotBlank TipoInsumo tipoInsumo) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipoInsumo = tipoInsumo;
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

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public TipoInsumo getTipoInsumo() {
        return tipoInsumo;
    }

    public void setTipoInsumo(TipoInsumo tipoInsumo) {
        this.tipoInsumo = tipoInsumo;
    }

    @Override
    public String toString() {
        return "Insumo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", tipoInsumo=" + tipoInsumo +
                '}';
    }
}
