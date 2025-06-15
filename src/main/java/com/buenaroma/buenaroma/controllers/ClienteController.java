package com.buenaroma.buenaroma.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.buenaroma.buenaroma.entities.Cliente;
import com.buenaroma.buenaroma.services.ClienteServices;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("crud/clientes")
public class ClienteController {
    private final ClienteServices clienteServices;

    @GetMapping
    public String mostrarCliente(Model model) {
        model.addAttribute("mostrar", clienteServices.obtenerTodos());
        model.addAttribute("cliente", new Cliente());
        return "crud/clientes";
    }

    @PostMapping("/guardarClientes")
    public String guardarCliente(@ModelAttribute Cliente cliente) {
        clienteServices.actualizar(cliente);
        return "redirect:/crud/clientes";
    }

    @GetMapping("/editarClientes")
    public String editarCliente(@RequestParam("id") int id, Model model) {
        model.addAttribute("cliente", clienteServices.obtenerUno(id));
        model.addAttribute("mostrar", clienteServices.obtenerTodos());
        return "crud/clientes";
    }

    @PostMapping("/eliminarClientes")
    public String eliminarCliente(@RequestParam("id") Integer id) {
        clienteServices.eliminar(id);
        return "redirect:/crud/clientes";
    }
}
