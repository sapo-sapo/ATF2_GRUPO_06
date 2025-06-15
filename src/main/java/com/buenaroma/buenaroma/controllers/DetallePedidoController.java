package com.buenaroma.buenaroma.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.buenaroma.buenaroma.entities.DetallePedido;
import com.buenaroma.buenaroma.services.DetallePedidoServices;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("crud/detalle-pedidos")
public class DetallePedidoController {
    private final DetallePedidoServices detallePedidoServices;

    @GetMapping
    public String mostrarDetallePedido(Model model) {
        model.addAttribute("mostrar", detallePedidoServices.obtenerTodos());
        model.addAttribute("detallePedido", new DetallePedido());
        return "crud/detallePedidos";
    }

    @PostMapping("/guardarDetallePedidos")
    public String guardarDetallePedido(@ModelAttribute DetallePedido detallePedido) {
        detallePedidoServices.actualizar(detallePedido);
        return "redirect:/crud/detallePedidos";
    }

    @GetMapping("/editarDetallePedidos")
    public String editarDetallePedido(@RequestParam("id") int id, Model model) {
        model.addAttribute("detallePedido", detallePedidoServices.obtenerUno(id));
        model.addAttribute("mostrar", detallePedidoServices.obtenerTodos());
        return "crud/detallePedidos";
    }

    @PostMapping("/eliminarDetallePedidos")
    public String eliminarDetallePedido(@RequestParam("id") Integer id) {
        detallePedidoServices.eliminar(id);
        return "redirect:/crud/detallePedidos";
    }
}