package proyectolovit.proyectolovit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    private String descripcion;

    private float precio;

    private int minimo_compra;

    private float alto;

    private float ancho;

    private float peso;

    private int tags;

    private long imagen_portada;

    private ArrayList<Imagen> imagenes_adicionales;

    private ArrayList<InsumoProducto> insumosReq;



}
