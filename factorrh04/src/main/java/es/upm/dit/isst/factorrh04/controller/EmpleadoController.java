package es.upm.dit.isst.factorrh04.controller;

import es.upm.dit.isst.factorrh04.model.Empleado;
import es.upm.dit.isst.factorrh04.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmpleadoController {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping("/listadeempleados")
    public String mostrarListaEmpleados(Model model) {
        List<Empleado> listaEmpleados = empleadoRepository.findAll();
        model.addAttribute("empleados", listaEmpleados);
        return "listadeempleados"; // Esta es la vista donde se mostrarán los empleados
    }
}
