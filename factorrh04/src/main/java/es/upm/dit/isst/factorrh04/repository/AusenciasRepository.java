package es.upm.dit.isst.factorrh04.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;


// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

// import org.springframework.data.jpa.repository.Query;
import es.upm.dit.isst.factorrh04.model.Ausencias;
// import java.util.Date;

public interface AusenciasRepository extends CrudRepository<Ausencias, Integer> {

    List<Ausencias> findByIdempleado(String idEmpleado);

    Optional<Ausencias> findByIdausencia(Integer idausencia);

    @jakarta.transaction.Transactional

    void deleteByIdausencia(Integer idpuesto);
}

