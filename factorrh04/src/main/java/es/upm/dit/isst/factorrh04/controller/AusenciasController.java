package es.upm.dit.isst.factorrh04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AusenciasController {

    @GetMapping("/ausencias")
    public String mostrarFormularioAusencias() {
        return "ausencias"; // Devuelve el nombre del archivo HTML sin la extensión
    }
}
