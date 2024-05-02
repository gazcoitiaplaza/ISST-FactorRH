package es.upm.dit.isst.factorrh04.repository;

import es.upm.dit.isst.factorrh04.model.Ausencias;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AusenciasRepository extends CrudRepository<Ausencias, Long> {
    List<Ausencias> findByNombreUsuario(String nombreUsuario);
}
