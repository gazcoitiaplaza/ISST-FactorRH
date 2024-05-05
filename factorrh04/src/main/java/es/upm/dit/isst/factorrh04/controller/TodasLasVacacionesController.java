package es.upm.dit.isst.factorrh04.controller;

import es.upm.dit.isst.factorrh04.model.Vacaciones;
import es.upm.dit.isst.factorrh04.repository.VacacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TodasLasVacacionesController {

    @Autowired
    private VacacionesRepository vacacionesRepository;

    @GetMapping("/todasvacaciones")
    public String mostrarTodasLasVacaciones(Model model) {
        List<Vacaciones> todasLasVacaciones = vacacionesRepository.findAll();
        model.addAttribute("todasLasVacaciones", todasLasVacaciones);
        return "controlvacaciones";
    }
}
