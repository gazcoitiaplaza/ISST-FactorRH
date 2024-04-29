package es.upm.dit.isst.factorrh04.repository;

import es.upm.dit.isst.factorrh04.model.Ausencias;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AusenciasRepository extends JpaRepository<Ausencias, Long> {
    List<Ausencias> findByNombreUsuario(String nombreUsuario);
}
