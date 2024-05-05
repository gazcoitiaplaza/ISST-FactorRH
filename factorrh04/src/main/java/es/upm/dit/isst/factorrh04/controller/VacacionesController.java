package es.upm.dit.isst.factorrh04.controller;

import es.upm.dit.isst.factorrh04.model.Vacaciones;
import es.upm.dit.isst.factorrh04.repository.VacacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vacaciones")
public class VacacionesController {

    @Autowired
    private VacacionesRepository vacacionesRepository;

    @GetMapping
    public String mostrarFormulario(Model model) {
        model.addAttribute("vacaciones", new Vacaciones());
        model.addAttribute("listaVacaciones", listaVacaciones());
        return "vacaciones";
    }

    @PostMapping("/registrar")
    public String registrarVacacion(@ModelAttribute Vacaciones vacaciones) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        vacaciones.setNombreUsuario(username);
        vacacionesRepository.save(vacaciones);
        return "redirect:/vacaciones";
    }

    @ModelAttribute("listaVacaciones")
    public List<Vacaciones> listaVacaciones() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return vacacionesRepository.findByNombreUsuario(username);
    }
}
