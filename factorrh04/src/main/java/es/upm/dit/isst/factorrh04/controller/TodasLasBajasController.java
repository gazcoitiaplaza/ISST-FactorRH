package es.upm.dit.isst.factorrh04.controller;

import es.upm.dit.isst.factorrh04.model.Bajas;
import es.upm.dit.isst.factorrh04.repository.BajasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TodasLasBajasController {

    @Autowired
    private BajasRepository bajasRepository;

    @GetMapping("/todasbajas")
    public String mostrarTodasLasBajas(Model model) {
        List<Bajas> todasLasBajas = bajasRepository.findAll();
        model.addAttribute("todasLasBajas", todasLasBajas);
        return "controlbajas";
    }
}
