package es.upm.dit.isst.factorrh04.controller;

import es.upm.dit.isst.factorrh04.model.Bajas;
import es.upm.dit.isst.factorrh04.repository.BajasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/bajas")
public class BajasController {

    @Autowired
    private BajasRepository bajasRepository;

    @GetMapping
    public String mostrarFormulario(Model model) {
        model.addAttribute("baja", new Bajas());
        model.addAttribute("listaBajas", listaBajas());
        return "bajas";
    }

    @PostMapping("/registrar")
    public String registrarBaja(@ModelAttribute Bajas baja) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        baja.setNombreUsuario(username);
        bajasRepository.save(baja);
        return "redirect:/bajas";
    }

    @ModelAttribute("listaBajas")
    public List<Bajas> listaBajas() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return bajasRepository.findByNombreUsuario(username);
    }


}