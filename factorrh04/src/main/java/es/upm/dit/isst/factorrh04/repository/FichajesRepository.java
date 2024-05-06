package es.upm.dit.isst.factorrh04.repository;

import es.upm.dit.isst.factorrh04.model.Fichajes;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface FichajesRepository extends CrudRepository<Fichajes, Long> {
    List<Fichajes> findByNombreUsuario(String nombreUsuario);
    List<Fichajes> findAll();
}
