package es.upm.dit.isst.factorrh04.repository; // Add the missing package declaration ok
import java.sql.Date; // Add the missing import statement ok
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import es.upm.dit.isst.factorrh04.model.Empleado;

public interface EmpleadoRepository extends CrudRepository<Empleado, String> {

    List<Empleado> findByidEmpleado(String id);

    Empleado findByEmail(String email);
    
    @Autowired
    @Query(value = "SELECT id_empleado, cp, iban, nass, nif, swift, antiguedad, apellido_1, apellido_2," +
                   "direccion, email, email_particular, fecha_alta, fecha_baja, nombre, " +
                   "password, puesto, sueldo_base, telefono " +
                   "FROM empleado WHERE fecha_alta <= :fin and (fecha_baja >= :inicio or fecha_baja is null)" , nativeQuery = true)
    List<Empleado> seleccionarEmpleadosNomina(Date inicio, Date fin);
}