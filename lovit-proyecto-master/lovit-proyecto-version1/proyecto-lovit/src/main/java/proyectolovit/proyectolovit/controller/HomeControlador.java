package proyectolovit.proyectolovit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import proyectolovit.proyectolovit.model.Producto;
import proyectolovit.proyectolovit.model.Tag;
import proyectolovit.proyectolovit.repositories.ProductoRepositorio;
import proyectolovit.proyectolovit.repositories.TagRepositorio;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class HomeControlador {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Autowired
    private TagRepositorio tagRepositorio;

    List<Producto> productos;

    @GetMapping("")
    public ModelAndView verPaginaDeInicio() {
        List<Producto> ultimosProductos = productoRepositorio.findAll(PageRequest.of(0, 4, Sort.by("precio").descending())).toList();
        return new ModelAndView("index")
                .addObject("ultimosProductos", ultimosProductos);
    }

    @GetMapping("/productos")
    public ModelAndView listarProductos(@PageableDefault(sort = "precio", direction = Sort.Direction.DESC) Pageable pageable) {
        this.productos=null;
        Page<Producto> productos = productoRepositorio.findAll(pageable);
        return new ModelAndView("productos")
                .addObject("productos", productos);
    }

    @PostMapping("/productos")
    public ModelAndView listarProductosBuscados(String busqueda){
        List<Producto> productos = productoRepositorio.findByNombreContaining(busqueda);
        List<Tag> tagsBuscados= tagRepositorio.findByNombreContaining(busqueda);
        if(!tagsBuscados.isEmpty()){
            for (Tag tag:tagsBuscados) {
                productos.addAll(productoRepositorio.findByTags(tag));
            }

        }
        this.productos=productos;
        return new ModelAndView("productos")
                .addObject("productos", productos);
    }
    @GetMapping("/productos/{id}")
    public ModelAndView mostrarDetallesDeProducto(@PathVariable Integer id) {
        Producto producto = productoRepositorio.getOne(id);
        return new ModelAndView("producto").addObject("producto", producto);
    }

    @GetMapping("/menorMayor")
    public ModelAndView ordenMenorMayor() {
        if(this.productos!=null){
            Collections.sort(productos, (d1, d2) -> {
                return Float.compare(d1.getPrecio(),d2.getPrecio());
            });

            return new ModelAndView("productos")
                    .addObject("productos", productos);
        }
        List<Producto> menorMayor = productoRepositorio.findAll(Sort.by("precio").descending());
        return new ModelAndView("menorMayor")
                .addObject("menorMayor", menorMayor);
    }

    @GetMapping("/mayorMenor")
    public ModelAndView ordenMayorMenor(){
        if(this.productos!=null){
            Collections.sort(productos, (d1, d2) -> {
                return Float.compare(d2.getPrecio(),d1.getPrecio());
            });

            return new ModelAndView("productos")
                    .addObject("productos", productos);
        }
        List<Producto> productos = productoRepositorio.findAll(Sort.by("precio").ascending());
        return new ModelAndView("productos")
                .addObject("productos", productos);
    }

    @GetMapping("/aZ")
    public ModelAndView ordenAz() {
        if(this.productos!=null){
            Collections.sort(productos, (d1, d2) -> {
                return d2.getNombre().compareTo(d1.getNombre());
            });
            return new ModelAndView("productos")
                    .addObject("productos", productos);
        }

        List<Producto> aZ = productoRepositorio.findAll(Sort.by("nombre").ascending());
        return new ModelAndView("aZ")
                .addObject("aZ", aZ);
    }

    @GetMapping("/zA")
    public ModelAndView ordenZa() {

        if(this.productos!=null){
            Collections.sort(productos, (d1, d2) -> {
                return d1.getNombre().compareTo(d2.getNombre());
            });
            return new ModelAndView("productos")
                    .addObject("productos", productos);
        }
        List<Producto> zA = productoRepositorio.findAll(Sort.by("nombre").descending());
        return new ModelAndView("zA")
                .addObject("zA", zA);
    }

    @GetMapping("/productos/tags/{tag}")
    public ModelAndView obtenerProductos(@PathVariable("tag" ) String tagNombre){
        List<Tag> tags = tagRepositorio.findByNombreContaining(tagNombre);
        List<Producto> productos=null;
        if(!tags.isEmpty()){
            productos = productoRepositorio.findByTags(tags.get(0));
        }
        return new ModelAndView("productos")
                .addObject("productos", productos);
    }

}
