package pe.tuna.proyecto1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.tuna.proyecto1.models.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/app") // Ruta del controlador de primer nivel, es opcional
public class HomeController {
    // Podemos obtener valores desde el properties
    @Value("${texto.homecontroller.home.titulo}")
    private String tituloHome;

    @Value("${texto.homecontroller.perfil.titulo}")
    private String tituloPerfil;

    @Value("${texto.homecontroller.listar.titulo}")
    private String tituloListar;

    /* Metodo de inicio
     * Podemos mapear varias rutas de respuesta a un mismo metodo
     * por ejemplo mapeando tres URLs
     * @GetMapping({"index", "/", "/home"})
     */
    @GetMapping({"/", "", "/index", "/home"})
    public String home(Model model){
        model.addAttribute("titulo", tituloHome);
        return "index";
    }

    @GetMapping("/perfil")
    public String perfil(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Miguel");
        usuario.setApellido("Chinchay");
        usuario.setEmail("miguel@tuna.pe");

        // Le pasamos a la vista los datos
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", tituloPerfil);

        return "perfil";
    }

    @GetMapping("/listar")
    public String listar(Model model){
        List<Usuario> usuarioList = Arrays.asList(new Usuario("Miguel","Chinchay","miguel@tuna.pe"),
                                                new Usuario("Jhon", "Doe", "jhon@tuna.pe"),
                                                new Usuario("Richart","Stallman","richart@tuna.pe"));

        model.addAttribute("titulo",tituloListar);
        model.addAttribute("usuarioList", usuarioList);

        return "listar";
    }

    /*
     * Cuando queremos pasar un dato en comun a los diferentes metodos handlers usamos el @ModelAttribute
     * de ese modo podemos tener disponible esa variable en todos los metodos
     * importante esto ultimo.
     */
    @ModelAttribute("poblarSelectUsuarios")
    public List<Usuario> poblarSelectUsuarios(){
        List<Usuario> usuarioList = Arrays.asList(new Usuario("Miguel","Chinchay","miguel@tuna.pe"),
                new Usuario("Jhon", "Doe", "jhon@tuna.pe"),
                new Usuario("Richart","Stallman","richart@tuna.pe"));

        return usuarioList;
    }
}

