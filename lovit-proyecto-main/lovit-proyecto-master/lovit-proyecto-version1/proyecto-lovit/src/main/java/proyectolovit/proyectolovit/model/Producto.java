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

}
