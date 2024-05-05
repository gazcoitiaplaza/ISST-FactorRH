package es.upm.dit.isst.factorrh04.repository;

import es.upm.dit.isst.factorrh04.model.GestionarBajas;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface GestionarBajasRepository extends CrudRepository<GestionarBajas, Long> {
    List<GestionarBajas> findByNombreUsuario(String nombreUsuario);
    List<GestionarBajas> findAll();
}
