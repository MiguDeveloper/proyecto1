package pe.tuna.proyecto1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {
    @GetMapping("/")
    public String home(){
        //return "redirect:/app/index"; podemos aprovechar para redirigir a una pagina externa
        // Podemos usar forward que lo hace por detras manteniendo la data del request
        // recordar siempre que forward es solo para invocar rutas de controladores y no externas
        return "forward:/app/index";
    }
}
