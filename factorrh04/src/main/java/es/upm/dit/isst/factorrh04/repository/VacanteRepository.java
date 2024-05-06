package es.upm.dit.isst.factorrh04.repository;
import es.upm.dit.isst.factorrh04.model.Vacante;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VacanteRepository extends CrudRepository<Vacante, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    List<Vacante> findAll();
}
