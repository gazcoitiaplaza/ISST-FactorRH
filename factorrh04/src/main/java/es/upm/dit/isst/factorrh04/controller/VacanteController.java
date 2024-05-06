package es.upm.dit.isst.factorrh04.controller;

import es.upm.dit.isst.factorrh04.model.Vacante;
import es.upm.dit.isst.factorrh04.repository.VacanteRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class VacanteController {

    @Autowired
    private VacanteRepository vacanteRepository;

    @GetMapping("/listaVacantes")
    public String mostrarListaVacantes(Model model) {
        List<Vacante> listaVacantes = vacanteRepository.findAll();
        model.addAttribute("vacantes", listaVacantes);
        return "listaVacantes"; // Esta es la vista donde se mostrarán las vacantes
    }
}
