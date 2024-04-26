package es.upm.dit.isst.factorrh04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeRhController {

    @GetMapping("/home_rh")
    public String homeRH() {
        return "home_rh";  // Asegúrate de que home_rh.html está en src/main/resources/templates
    }
}
