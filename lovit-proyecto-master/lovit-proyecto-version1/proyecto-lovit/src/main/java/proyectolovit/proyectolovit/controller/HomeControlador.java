package proyectolovit.proyectolovit.controller;

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
public class HomeControlador {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Autowired
    private TagRepositorio tagRepositorio;

    @GetMapping("")
    public ModelAndView verPaginaDeInicio() {
        List<Producto> ultimosProductos = productoRepositorio.findAll(PageRequest.of(0, 4, Sort.by("precio").descending())).toList();
        return new ModelAndView("index")
                .addObject("ultimosProductos", ultimosProductos);
    }

    @GetMapping("/productos")
    public ModelAndView listarProductos(@PageableDefault(sort = "precio", direction = Sort.Direction.DESC) Pageable pageable) {
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

        return new ModelAndView("productos")
                .addObject("productos", productos);
    }
    @GetMapping("/productos/{id}")
    public ModelAndView mostrarDetallesDeProducto(@PathVariable Integer id) {
        Producto producto = productoRepositorio.getOne(id);
        return new ModelAndView("producto").addObject("producto", producto);
    }

    @GetMapping("/menorMayor")
    public ModelAndView ordenMenorMayor(@ModelAttribute("productos")List<Producto>productos) {
        List<Producto> menorMayor = productoRepositorio.findAll(PageRequest.of(0, 4, Sort.by("precio").ascending())).toList();
        return new ModelAndView("menorMayor")
                .addObject("menorMayor", productos);
    }

    @GetMapping("/aZ")
    public ModelAndView ordenAz() {
        List<Producto> aZ = productoRepositorio.findAll(PageRequest.of(0, 4, Sort.by("nombre").ascending())).toList();
        return new ModelAndView("aZ")
                .addObject("aZ", aZ);
    }

    @GetMapping("/zA")
    public ModelAndView ordenZa() {
        List<Producto> zA = productoRepositorio.findAll(PageRequest.of(0, 4, Sort.by("nombre").descending())).toList();
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
