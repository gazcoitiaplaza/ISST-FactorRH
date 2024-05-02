package es.upm.dit.isst.factorrh04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // Esta anotación es necesaria
public class NominaController {

    @GetMapping("/nomina")
    public String nomina() {
        return "nomina"; // Asegúrate de que existe nomina.html en src/main/resources/templates
    }
}
