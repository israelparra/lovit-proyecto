package proyectolovit.proyectolovit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import proyectolovit.proyectolovit.model.Producto;

public interface ProductoRepositorio  extends JpaRepository<Producto, Integer> {
}
