package es.upm.dit.isst.factorrh04.repository;

import es.upm.dit.isst.factorrh04.model.Vacaciones;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface VacacionesRepository extends CrudRepository<Vacaciones, Long> {
    List<Vacaciones> findByNombreUsuario(String nombreUsuario);
    List<Vacaciones> findAll();
}
