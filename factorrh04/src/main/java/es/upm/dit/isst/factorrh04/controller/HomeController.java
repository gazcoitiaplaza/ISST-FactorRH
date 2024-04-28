package es.upm.dit.isst.factorrh04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // Esta anotación es necesaria
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home"; // Asegúrate de que existe home.html en src/main/resources/templates
    }
}
