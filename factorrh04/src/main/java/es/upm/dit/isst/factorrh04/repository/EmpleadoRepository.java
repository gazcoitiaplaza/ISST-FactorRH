package es.upm.dit.isst.factorrh04.repository; 

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import es.upm.dit.isst.factorrh04.model.Empleado;

public interface EmpleadoRepository extends CrudRepository<Empleado, String> {

    List<Empleado> findByidEmpleado(String id);
    List<Empleado> findAll();

    Empleado findByEmail(String email);
    

}