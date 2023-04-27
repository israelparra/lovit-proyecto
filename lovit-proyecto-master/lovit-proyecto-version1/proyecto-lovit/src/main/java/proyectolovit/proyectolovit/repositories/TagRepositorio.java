package proyectolovit.proyectolovit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import proyectolovit.proyectolovit.model.Tag;

import java.util.List;

public interface TagRepositorio extends JpaRepository<Tag,Integer> {

    List<Tag> findByNombreContaining(String nombre);
}
