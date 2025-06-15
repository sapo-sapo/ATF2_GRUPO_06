package com.buenaroma.buenaroma.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.buenaroma.buenaroma.entities.Reserva;
import com.buenaroma.buenaroma.services.ReservaServices;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("crud/reservas")
public class ReservaController {
    private final ReservaServices reservaServices;

    @GetMapping
    public String mostrarReserva(Model model) {
        model.addAttribute("mostrar", reservaServices.obtenerTodos());
        model.addAttribute("reserva", new Reserva());
        return "crud/reservas";
    }

    @PostMapping("/guardarReservas")
    public String guardarReserva(@ModelAttribute Reserva reserva) {
        reservaServices.actualizar(reserva);
        return "redirect:/crud/reservas";
    }

    @GetMapping("/editarReservas")
    public String editarReserva(@RequestParam("id") int id, Model model) {
        model.addAttribute("reserva", reservaServices.obtenerUno(id));
        model.addAttribute("mostrar", reservaServices.obtenerTodos());
        return "crud/reservas";
    }

    @PostMapping("/eliminarReservas")
    public String eliminarReserva(@RequestParam("id") Integer id) {
        reservaServices.eliminar(id);
        return "redirect:/crud/reservas";
    }
}
