package es.upm.dit.isst.factorrh04.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.upm.dit.isst.factorrh04.model.Nomina;

@Repository
public interface NominaRepository extends CrudRepository<Nomina, Long> {
}
