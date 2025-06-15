package com.buenaroma.buenaroma.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.buenaroma.buenaroma.entities.Feedback;
import com.buenaroma.buenaroma.services.FeedbackServices;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("crud/feedbacks")
public class FeedbackController {
    private final FeedbackServices feedbackServices;

    @GetMapping
    public String mostrarFeedback(Model model) {
        model.addAttribute("mostrar", feedbackServices.obtenerTodos());
        model.addAttribute("feedback", new Feedback());
        return "crud/feedbacks";
    }

    @PostMapping("/guardarFeedbacks")
    public String guardarFeedback(@ModelAttribute Feedback feedback) {
        feedbackServices.actualizar(feedback);
        return "redirect:/crud/feedbacks";
    }

    @GetMapping("/editarFeedbacks")
    public String editarFeedback(@RequestParam("id") int id, Model model) {
        model.addAttribute("feedback", feedbackServices.obtenerUno(id));
        model.addAttribute("mostrar", feedbackServices.obtenerTodos());
        return "crud/feedbacks";
    }

    @PostMapping("/eliminarFeedbacks")
    public String eliminarFeedback(@RequestParam("id") Integer id) {
        feedbackServices.eliminar(id);
        return "redirect:/crud/feedbacks";
    }
}
