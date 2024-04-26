package es.upm.dit.isst.factorrh04.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController {

    @PostMapping("/saveTime")
    public String saveTime(@RequestBody Map<String, Long> payload) {
        // Aquí lógica para guardar en la base de datos
        // payload.get("time") te dará el tiempo en milisegundos
        System.out.println("Tiempo recibido: " + payload.get("time"));
        // Guardar en la base de datos...
        
        return "Tiempo guardado con éxito";
    }
}
