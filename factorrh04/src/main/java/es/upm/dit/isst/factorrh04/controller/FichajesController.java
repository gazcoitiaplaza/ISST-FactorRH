package es.upm.dit.isst.factorrh04.controller;

import es.upm.dit.isst.factorrh04.model.Fichajes;
import es.upm.dit.isst.factorrh04.repository.FichajesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/fichajes")
public class FichajesController {

    @Autowired
    private FichajesRepository fichajesRepository;

    @GetMapping
    public String mostrarFormulario(Model model) {
        model.addAttribute("fichaje", new Fichajes());
        model.addAttribute("listaFichajes", listaFichajes());
        return "fichajes";
    }

    @PostMapping("/registrar")
    public String registrarFichaje(@ModelAttribute Fichajes fichaje) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        fichaje.setNombreUsuario(username);
        fichaje.setHoraEntrada(LocalDateTime.now());
        fichajesRepository.save(fichaje);
        return "redirect:/fichajes";
    }

    @ModelAttribute("listaFichajes")
    public List<Fichajes> listaFichajes() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return fichajesRepository.findByNombreUsuario(username);
    }
}
