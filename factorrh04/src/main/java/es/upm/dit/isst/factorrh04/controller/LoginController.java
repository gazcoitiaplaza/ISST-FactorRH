package es.upm.dit.isst.factorrh04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";  // Devuelve la vista del formulario de inicio de sesión personalizado
    }
}
