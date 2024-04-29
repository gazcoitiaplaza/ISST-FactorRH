package es.upm.dit.isst.factorrh04.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class Controller {
    @GetMapping("/")
    public String inicio() {
        return "login.html";
    }

}
