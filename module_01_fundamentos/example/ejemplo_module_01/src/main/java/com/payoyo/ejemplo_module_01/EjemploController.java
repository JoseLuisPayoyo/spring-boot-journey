package com.payoyo.ejemplo_module_01;

import java.lang.management.ManagementFactory;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EjemploController {

    // decir hola en spring. Map hace como un JSON
    @GetMapping("/hello")
    public Map<String, String> hello() {
        return Map.of("message", "Hola Spring Boot 👋");
    }

    // ejemplo 2
    @Value("${app.version}") // inyectamos valore con value
    private String version;
    
    @GetMapping("/status")
    public Map<String, Object> status(){
        /*
         * usar clases estándar de Java para añadir datos dinamicos
         */
        long uptimeMillis = ManagementFactory.getRuntimeMXBean().getUptime();
        long uptimeSeconds = uptimeMillis / 1000;

        /*
         * estructurar respuestas complejas
         */
        return Map.of(
            "app", "Spring Boot Journey",
            "version", version,
            "uptime", uptimeSeconds + "s",
            "message", "Servidor operativo"
        );
    }

}
