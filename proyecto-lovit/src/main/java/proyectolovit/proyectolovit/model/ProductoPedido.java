package proyectolovit.proyectolovit.model;

import javax.validation.constraints.NotNull;

public class ProductoPedido {

    private long id;

    @NotNull
    private int cantidad;
    @NotNull
    private float precioUnitario;
    @NotNull
    private float importe;

    public ProductoPedido() {
    }

    public ProductoPedido(@NotNull int cantidad, @NotNull float precioUnitario, @NotNull float importe) {
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.importe = importe;
    }

    public ProductoPedido(long id, @NotNull int cantidad, @NotNull float precioUnitario, @NotNull float importe) {
        this.id = id;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.importe = importe;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }
}
