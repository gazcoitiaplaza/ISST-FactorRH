package es.upm.dit.isst.factorrh04.repository; // Add the missing package declaration ok

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import es.upm.dit.isst.factorrh04.model.Jornadas;
import es.upm.dit.isst.factorrh04.model.jornadasPK;

@RepositoryRestResource(collectionResourceRel = "jornadas", path = "jornadas")
public interface JornadasRepository extends CrudRepository<Jornadas, jornadasPK> {
    List<Jornadas> findByIdEmpleado(String idEmpleado);
    List<Jornadas> findByFecha(LocalDate fecha);
    List<Jornadas> findByEstado(String estado);
    List<Jornadas> findByIncidenciaAndEstado(String incidencia, String estado);
    List<Jornadas> findByIdEmpleadoAndIncidenciaAndEstado(String idEmpleado, String incidencia, String estado);
}
