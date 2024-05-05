package es.upm.dit.isst.factorrh04.controller;

import es.upm.dit.isst.factorrh04.model.Ausencias;
import es.upm.dit.isst.factorrh04.repository.AusenciasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TodasLasAusenciasController {

    @Autowired
    private AusenciasRepository ausenciasRepository;

    @GetMapping("/todasausencias")
    public String mostrarTodasLasAusencias(Model model) {
        List<Ausencias> todasLasAusencias = ausenciasRepository.findAll();
        model.addAttribute("todasLasAusencias", todasLasAusencias);
        return "controlausencias"; // Página HTML para mostrar todas las ausencias
    }
}
