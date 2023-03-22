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
import proyectolovit.proyectolovit.repositories.ProductoRepositorio;
import proyectolovit.proyectolovit.services.AlmacenServicio;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminControlador {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Autowired
    private AlmacenServicio servicio;

    @GetMapping("")
   public ModelAndView verPaginaDeInicio(@PageableDefault(sort = "nombre", size = 5) Pageable pageable) {
        Page<Producto> productos = productoRepositorio.findAll(pageable);
       return new ModelAndView("admin/index").addObject("productos", productos);
    }

    @GetMapping("/productos/nuevo")
    public ModelAndView mostrarFormularioDeNuevoProducto() {
        List<Producto> tipos = productoRepositorio.findAll(Sort.by("nombre"));
        return new ModelAndView("nuevo-producto")
                .addObject("producto", new Producto())
                .addObject("tipos",tipos);
    }

    @PostMapping("/productos/nuevo")
    public ModelAndView registrarProducto(@Validated Producto producto, BindingResult bindingResult) {
//        if(bindingResult.hasErrors() || producto.getImagen_portada()==0) {
//            if(producto.getImagen_portada()==0) {
//                bindingResult.rejectValue("portada","MultipartNotEmpty");
//            }
//
//            List<Producto> tipos = productoRepositorio.findAll(Sort.by("nombre"));
//            return new ModelAndView("nuevo-producto")
//                    .addObject("producto",producto);
//        }

//        String rutaPortada = servicio.almacenarArchivo(producto.getImagen_portada()));
//        producto.setRutaPortada(rutaPortada);

        productoRepositorio.save(producto);
        return new ModelAndView("redirect:/admin");
    }







}
