package pe.tuna.proyecto1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("titulo", "Enviar parametros de la ruta '@Pathvariable'");
        return "variables/index";
    }

    @GetMapping("/string/{texto}")
    public String string(@PathVariable String texto, Model model){
        model.addAttribute("texto", "El texto enviado en la ruta es: " + texto);
        model.addAttribute("titulo", "Recibir parametros de la ruta '@Pathvariable'");
        return "variables/ver";
    }

    @GetMapping("/string/{texto}/{numero}")
    public String string(@PathVariable String texto, @PathVariable int numero, Model model){
        model.addAttribute("titulo", "Recibir params en la ruta");
        model.addAttribute("texto", "El texto de la ruta es: " + texto
        + " y el numero en el path es: " + numero);

        return "variables/ver";
    }
}
