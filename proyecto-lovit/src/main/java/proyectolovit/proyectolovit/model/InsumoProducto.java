package proyectolovit.proyectolovit.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class InsumoProducto {

    private long id;

    @NotBlank
    private Insumo insumo;

    @NotNull
    private float cantidad;

    public InsumoProducto(@NotBlank Insumo insumo, @NotNull float cantidad) {
        this.insumo = insumo;
        this.cantidad = cantidad;
    }

    public InsumoProducto(long id, @NotBlank Insumo insumo, @NotNull float cantidad) {
        this.id = id;
        this.insumo = insumo;
        this.cantidad = cantidad;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }
}
