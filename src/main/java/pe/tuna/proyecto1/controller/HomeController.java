package pe.tuna.proyecto1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    /* Metodo de inicio
     * Podemos mapear varias rutas de respuesta a un mismo metodo
     * por ejemplo mapeando tres URLs
     * @GetMapping({"index", "/", "/home"})
     */
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("titulo", "Sr.");
        return "index";
    }
}
