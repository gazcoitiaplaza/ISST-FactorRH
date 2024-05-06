package es.upm.dit.isst.factorrh04.controller;
import es.upm.dit.isst.factorrh04.model.Empleado;
import es.upm.dit.isst.factorrh04.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
public class GestionTalentoController {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping("/gestiontalento")
    public String gestionTalento(Model model) {
        // Obtener lista de candidatos (puedes implementar este método en el repositorio)
        List<Empleado> listaCandidatos = empleadoRepository.findAll();
        model.addAttribute("candidatos", listaCandidatos);
        model.addAttribute("nuevoEmpleado", new Empleado()); // Para el formulario de nuevo empleado
        return "gestiontalento"; // Devuelve el nombre de la vista HTML
    }

    @PostMapping("/agregarEmpleado")
    public String agregarEmpleado(@ModelAttribute Empleado empleado) {
        // Guardar el nuevo empleado en la base de datos
        empleadoRepository.save(empleado);
        return "redirect:/gestiontalento"; // Redirigir de vuelta a la página de gestión de talento
    }
}
