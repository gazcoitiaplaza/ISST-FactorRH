package es.upm.dit.isst.factorrh04.controller;

import es.upm.dit.isst.factorrh04.model.Ausencias;
import es.upm.dit.isst.factorrh04.repository.AusenciasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ausencias")
public class AusenciasController {

    @Autowired
    private AusenciasRepository ausenciasRepository;

    @GetMapping
    public String mostrarFormulario(Model model) {
        model.addAttribute("ausencia", new Ausencias());
        model.addAttribute("listaAusencias", listaAusencias());
        return "ausencias";
    }

    @PostMapping("/registrar")
    public String registrarAusencia(@ModelAttribute Ausencias ausencia) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        ausencia.setNombreUsuario(username);
        ausenciasRepository.save(ausencia);
        return "redirect:/ausencias";
    }

    @ModelAttribute("listaAusencias")
    public List<Ausencias> listaAusencias() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return ausenciasRepository.findByNombreUsuario(username);
    }
}
