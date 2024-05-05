package es.upm.dit.isst.factorrh04.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Empleado {
    
    @Id
    @NotBlank
    @Column(name = "id_Empleado", length = 4)
    private String idEmpleado;
    @Column(name = "nombre", length = 40)
    @NotBlank
    private String nombre;
    @Column(name = "apellido1", length = 40)
    private String apellido1;
    @Column(name = "apellido2", length = 40)
    private String apellido2;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "IBAN", length = 24)
    private String IBAN;
    @Column(name = "password", length = 50)
    private String password;
    @Column(name = "puesto", length = 5)
    private String puesto;

    public Empleado() {
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String iBAN) {
        IBAN = iBAN;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}