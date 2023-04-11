package proyectolovit.proyectolovit.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;

public class Pedido {

    private long id;

    @NotBlank
    private String cliente;

    @NotEmpty
    private ArrayList<ProductoPedido> productos;

    @NotNull
    private float costoTotal;

    @NotBlank
    private String status;

    @NotBlank
    private String notasCliente;

    @NotBlank
    private Date fecha;

    public Pedido() {
    }

    public Pedido(@NotBlank String cliente, @NotEmpty ArrayList<ProductoPedido> productos, @NotNull float costoTotal,
                  @NotBlank String status, @NotBlank String notasCliente, @NotBlank Date fecha) {
        this.id = id;
        this.cliente = cliente;
        this.productos = productos;
        this.costoTotal = costoTotal;
        this.status = status;
        this.notasCliente = notasCliente;
        this.fecha = fecha;
    }

    public Pedido(long id, @NotBlank String cliente, @NotEmpty ArrayList<ProductoPedido> productos, @NotNull float costoTotal,
                  @NotBlank String status, @NotBlank String notasCliente, @NotBlank Date fecha) {
        this.id = id;
        this.cliente = cliente;
        this.productos = productos;
        this.costoTotal = costoTotal;
        this.status = status;
        this.notasCliente = notasCliente;
        this.fecha = fecha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public ArrayList<ProductoPedido> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<ProductoPedido> productos) {
        this.productos = productos;
    }

    public float getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(float costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotasCliente() {
        return notasCliente;
    }

    public void setNotasCliente(String notasCliente) {
        this.notasCliente = notasCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente='" + cliente + '\'' +
                ", productos=" + productos +
                ", costoTotal=" + costoTotal +
                ", status='" + status + '\'' +
                ", notasCliente='" + notasCliente + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
