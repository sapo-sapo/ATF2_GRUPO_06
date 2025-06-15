package com.buenaroma.buenaroma.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.buenaroma.buenaroma.entities.Pedido;
import com.buenaroma.buenaroma.services.PedidoServices;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("crud/pedidos")
public class PedidoController {
    private final PedidoServices pedidoServices;

    @GetMapping
    public String mostrarPedido(Model model) {
        model.addAttribute("mostrar", pedidoServices.obtenerTodos());
        model.addAttribute("pedido", new Pedido());
        return "crud/pedidos";
    }

    @PostMapping("/guardarPedidos")
    public String guardarPedido(@ModelAttribute Pedido pedido) {
        pedidoServices.actualizar(pedido);
        return "redirect:/crud/pedidos";
    }

    @GetMapping("/editarPedidos")
    public String editarPedido(@RequestParam("id") int id, Model model) {
        model.addAttribute("pedido", pedidoServices.obtenerUno(id));
        model.addAttribute("mostrar", pedidoServices.obtenerTodos());
        return "crud/pedidos";
    }

    @PostMapping("/eliminarPedidos")
    public String eliminarPedido(@RequestParam("id") Integer id) {
        pedidoServices.eliminar(id);
        return "redirect:/crud/pedidos";
    }
}
