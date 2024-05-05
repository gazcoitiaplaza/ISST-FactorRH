package es.upm.dit.isst.factorrh04.controller;

import es.upm.dit.isst.factorrh04.model.GestionarBajas;
import es.upm.dit.isst.factorrh04.repository.GestionarBajasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/gestionarbajas")
public class GestionarBajasController {

    @Autowired
    private GestionarBajasRepository bajasRepository;

    @GetMapping
    public String mostrarFormulario(Model model) {
        model.addAttribute("gestionarbajas", new GestionarBajas());
        model.addAttribute("listaGestionarBajas", listaGestionarBajas());
        return "gestionarbajas";
    }
    

    @PostMapping("/registrar")
    public String gestionarBaja(@ModelAttribute GestionarBajas gestionarbajas) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        gestionarbajas.setNombreUsuario(username);
        return "redirect:/gestionarbajas";
    }

    @ModelAttribute("listaBajas")
    public List<GestionarBajas> listaGestionarBajas() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return bajasRepository.findByNombreUsuario(username);
    }


}