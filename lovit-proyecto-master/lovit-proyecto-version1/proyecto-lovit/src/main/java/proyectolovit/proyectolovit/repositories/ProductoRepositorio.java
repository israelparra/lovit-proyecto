package proyectolovit.proyectolovit.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import proyectolovit.proyectolovit.model.Producto;

import java.util.List;

public interface ProductoRepositorio  extends JpaRepository<Producto, Integer> {
    List<Producto> findByNombreContaining(String nombre);
}
