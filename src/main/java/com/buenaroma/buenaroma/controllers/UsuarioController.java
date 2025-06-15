package com.buenaroma.buenaroma.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.buenaroma.buenaroma.entities.Usuario;
import com.buenaroma.buenaroma.services.UsuarioServices;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("admin/usuarios")

public class UsuarioController {
    private final UsuarioServices usuarioServices;

    @GetMapping
    public String mostrarUsuario(Model model) {
        model.addAttribute("mostrar", usuarioServices.obtenerTodos());
        model.addAttribute("usuario", new Usuario());
        return "crud/usuarios";
    }

    @PostMapping("/guardarUsuarios")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        usuarioServices.actualizar(usuario);
        return "redirect:/crud/usuarios";
    }

    @GetMapping("/editarUsuarios")
    public String editarUsuario(@RequestParam("id") int id, Model model) {
        model.addAttribute("usuario", usuarioServices.obtenerUno(id));
        model.addAttribute("mostrar", usuarioServices.obtenerTodos());
        return "crud/usuarios";
    }

    @PostMapping("/eliminarUsuarios")
    public String eliminarUsuario(@RequestParam("id") Integer id) {
        usuarioServices.eliminar(id);
        return "redirect:/crud/usuarios";
    }
}