package pe.tuna.proyecto1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

    /*
     * Cuando queremos enviar parametros desde la vista al controlador
     * usaremos la anotacion @RequestParam
     */

    @GetMapping("/")
    public String index(Model model){
        return "params/index";
    }

    @GetMapping("/string")
    public String string(
            @RequestParam(name = "texto",
                    required = false,
                    defaultValue = "No registra param") String texto,
            Model model) {

        model.addAttribute("texto", "Valor recibido: " + texto);

        return "params/ver";
    }

    @GetMapping("/params-mix")
    public String param_mix(@RequestParam String saludo,
                            @RequestParam int numero,
                            Model model){
        model.addAttribute("texto", "El saludo enviado es: '"
        + saludo + "' y el numero es '" + numero + "'");
        return "params/ver";
    }
}
