package es.upm.dit.isst.factorrh04.repository;

import es.upm.dit.isst.factorrh04.model.Bajas;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface BajasRepository extends CrudRepository<Bajas, Long> {
    List<Bajas> findByNombreUsuario(String nombreUsuario);
    List<Bajas> findAll();
}
