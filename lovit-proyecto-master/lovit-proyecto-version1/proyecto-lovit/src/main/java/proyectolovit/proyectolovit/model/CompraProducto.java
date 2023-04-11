package proyectolovit.proyectolovit.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class CompraProducto {

    private long id;

    @NotBlank
    private Usuario usuario;

    @NotBlank
    private Insumo insumo;

    @NotBlank
    private Proveedor proveedor;

    @NotNull
    private float cantidad;

    @NotNull
    private float costoTotal;

    @NotNull
    private Date fecha;

    public CompraProducto(long id, @NotBlank Usuario usuario, @NotBlank Insumo insumo, @NotBlank Proveedor proveedor,
                          @NotNull float cantidad, @NotNull float costoTotal, @NotNull Date fecha) {
        this.id = id;
        this.usuario = usuario;
        this.insumo = insumo;
        this.proveedor = proveedor;
        this.cantidad = cantidad;
        this.costoTotal = costoTotal;
        this.fecha = fecha;
    }

    public CompraProducto(@NotBlank Usuario usuario, @NotBlank Insumo insumo, @NotBlank Proveedor proveedor,
                          @NotNull float cantidad, @NotNull float costoTotal, @NotNull Date fecha) {
        this.usuario = usuario;
        this.insumo = insumo;
        this.proveedor = proveedor;
        this.cantidad = cantidad;
        this.costoTotal = costoTotal;
        this.fecha = fecha;
    }
}
