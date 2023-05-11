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
import org.springframework.web.bind.annotation.PathVariable;
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
   public ModelAndView verPaginaDeInicio(@PageableDefault(sort = "nombre") Pageable pageable) {
        List<Producto> productos = productoRepositorio.findAll();
       return new ModelAndView("admin/index").addObject("productos", productos);
    }

    @GetMapping("/productos/nuevo")
    public ModelAndView mostrarFormularioDeNuevoProducto() {
        List<Tag> tags = tagRepositorio.findAll(Sort.by("nombre"));
        return new ModelAndView("admin/nuevo-producto")
                .addObject("producto",new Producto())
                .addObject("tags",tags);
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
        return new ModelAndView("/admin/index")
                .addObject("productos", productos);
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

    @GetMapping("/productos/{id}/editar")
    public ModelAndView mostrarFormilarioDeEditarProducto(@PathVariable Integer id) {
        Producto producto = productoRepositorio.getOne(id);
        List<Tag> tags = tagRepositorio.findAll(Sort.by("nombre"));

        return new ModelAndView("admin/editar-producto")
                .addObject("producto",producto)
                .addObject("tags",tags);
    }

    @PostMapping("/productos/{id}/editar")
    public ModelAndView actualizarProducto(@PathVariable Integer id,@Validated Producto producto,BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            List<Tag> tags = tagRepositorio.findAll(Sort.by("nombre"));
            return new ModelAndView("admin/editar-producto")
                    .addObject("producto",producto)
                    .addObject("tags",tags);
        }

        Producto productoBD = productoRepositorio.getOne(id);
        productoBD.setNombre(producto.getNombre());
        productoBD.setDescripcion(producto.getDescripcion());
        productoBD.setPrecio(producto.getPrecio());
        productoBD.setMinimoCompra(producto.getMinimoCompra());
        productoBD.setAlto(producto.getAlto());
        productoBD.setAncho(producto.getAncho());
        productoBD.setPeso(producto.getPeso());
        productoBD.setTags(producto.getTags());

        if(!producto.getPortada().isEmpty()) {
            servicio.eliminarArchivo(productoBD.getImagenRuta());
            String rutaPortada = servicio.almacenarArchivo(producto.getPortada());
            producto.setImagenRuta(rutaPortada);
        }

        productoRepositorio.save(productoBD);
        return new ModelAndView("redirect:/admin");
    }

    @PostMapping("/productos/{id}/eliminar")
    public String eliminarProducto(@PathVariable Integer id) {
        Producto producto = productoRepositorio.getOne(id);
        productoRepositorio.delete(producto);
        servicio.eliminarArchivo(producto.getImagenRuta());

        return "redirect:/admin";
    }






}
