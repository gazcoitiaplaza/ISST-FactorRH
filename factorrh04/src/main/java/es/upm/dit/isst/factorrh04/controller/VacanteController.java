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

    @GetMapping("/listaVacantes2")
    public String mostrarListaVacantes2(Model model) {
        List<Vacante> listaVacantes = vacanteRepository.findAll();
        model.addAttribute("vacantes", listaVacantes);
        return "listaVacantes2"; // Esta es la vista donde se mostrarán las vacantes
    }


    @PostMapping("/definirVacante")
    public String definirVacante(@ModelAttribute Vacante vacante) {
        // Guardar la vacante en la base de datos
        vacanteRepository.save(vacante);
        
        // Redirigir a alguna página de confirmación o a la lista de vacantes
        return "redirect:/listaVacantes";
    }

    @PostMapping("/borrarVacante")
    public String borrarVacante(@RequestParam Long id, Model model) {
        vacanteRepository.deleteById(id);
        return "redirect:/listaVacantes2";
    }

}


