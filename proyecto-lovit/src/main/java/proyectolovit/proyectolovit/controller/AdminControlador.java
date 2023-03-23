package proyectolovit.proyectolovit.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import proyectolovit.proyectolovit.model.Producto;
import proyectolovit.proyectolovit.model.Tag;
import proyectolovit.proyectolovit.repositories.ProductoRepositorio;
import proyectolovit.proyectolovit.repositories.TagRepositorio;
import proyectolovit.proyectolovit.services.AlmacenServicio;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminControlador {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Autowired
    private TagRepositorio tagRepositorio;

    @Autowired
    private AlmacenServicio servicio;

    @GetMapping("")
   public ModelAndView verPaginaDeInicio(@PageableDefault(sort = "nombre", size = 5) Pageable pageable) {
        Page<Producto> productos = productoRepositorio.findAll(pageable);
       return new ModelAndView("admin/index").addObject("productos", productos);
    }

    @GetMapping("/productos/nuevo")
    public ModelAndView mostrarFormularioDeNuevoProducto() {
        List<Tag> tags = tagRepositorio.findAll(Sort.by("nombre"));
        return new ModelAndView("admin/nuevo-producto")
                .addObject("producto",new Producto())
                .addObject("tags",tags);
    }

    @PostMapping("/productos/nuevo")
    public ModelAndView registrarProducto(@Validated Producto producto, BindingResult bindingResult) {
        if(bindingResult.hasErrors() || producto.getPortada().isEmpty()) {
            if(producto.getPortada().isEmpty()) {
                bindingResult.rejectValue("portada","MultipartNotEmpty");
            }

            List<Tag> tags = tagRepositorio.findAll(Sort.by("nombre"));
            return new ModelAndView("admin/nuevo-producto")
                    .addObject("producto",producto)
                    .addObject("tags",tags);
        }

        String rutaPortada = servicio.almacenarArchivo(producto.getPortada());
        producto.setImagenRuta(rutaPortada);

        productoRepositorio.save(producto);

        productoRepositorio.save(producto);
        return new ModelAndView("redirect:/admin");
    }







}
