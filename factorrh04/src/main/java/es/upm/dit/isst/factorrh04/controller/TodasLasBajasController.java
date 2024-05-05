package es.upm.dit.isst.factorrh04.controller;

import es.upm.dit.isst.factorrh04.model.Bajas;
import es.upm.dit.isst.factorrh04.repository.BajasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TodasLasBajasController { // Cambio de TodasLasAusenciasController a TodasLasBajasController

    @Autowired
    private BajasRepository bajasRepository; // Cambio de Ausencias a Bajas

    @GetMapping("/todasbajas")
    public String mostrarTodasLasBajas(Model model) { // Cambio de mostrarTodasLasAusencias a mostrarTodasLasBajas
        List<Bajas> todasLasBajas = bajasRepository.findAll(); // Cambio de Ausencias a Bajas
        model.addAttribute("todasLasBajas", todasLasBajas); // Cambio de Ausencias a Bajas
        return "controlbajas"; // Página HTML para mostrar todas las bajas
    }
}
