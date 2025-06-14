package com.buenaroma.buenaroma;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class NavegadorController {
    @GetMapping
    public String index() {
        return "inicio";
    }

    @GetMapping("/inicio.php")
    public String inicio() {
        return "inicio";
    }

    @GetMapping("/carta.php")
    public String carta() {
        return "carta";
    }

    @GetMapping("/reservas.php")
    public String reservas() {
        return "reservas";
    }

    @GetMapping("/admin/clientes")
    public String clientes() {
        return "admin/clientes";
    }

    @GetMapping("/blog.php")
    public String blog(Model model) {
        List<String> blogs = new ArrayList<>();
        blogs.add("La historia del café");
        blogs.add("Nuestras especialidades");
        blogs.add("ventos en la cafetería");
        model.addAttribute("blogs", blogs);
        return "blog";
    }

    @GetMapping("/contacto.php")
    public String contacto() {
        return "contacto";
    }

    @GetMapping("/login.php")
    public String login(Model model) {
        boolean esCliente = true;
        model.addAttribute("esCliente", esCliente);
        return "login";
    }
}
