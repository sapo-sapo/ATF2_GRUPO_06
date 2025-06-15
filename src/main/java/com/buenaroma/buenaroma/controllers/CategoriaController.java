package com.buenaroma.buenaroma.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.buenaroma.buenaroma.entities.Categoria;
import com.buenaroma.buenaroma.services.CategoriaServices;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("crud/categorias")
public class CategoriaController {
    private final CategoriaServices categoriaServices;

    @GetMapping
    public String mostrarCategoria(Model model) {
        model.addAttribute("mostrar", categoriaServices.obtenerTodos());
        model.addAttribute("categoria", new Categoria());
        return "crud/categorias";
    }

    @PostMapping("/guardarCategorias")
    public String guardarCategoria(@ModelAttribute Categoria categoria) {
        categoriaServices.actualizar(categoria);
        return "redirect:/crud/categorias";
    }

    @GetMapping("/editarCategorias")
    public String editarCategoria(@RequestParam("id") int id, Model model) {
        model.addAttribute("categoria", categoriaServices.obtenerUno(id));
        model.addAttribute("mostrar", categoriaServices.obtenerTodos());
        return "crud/categorias";
    }

    @PostMapping("/eliminarCategorias")
    public String eliminarCategoria(@RequestParam("id") Integer id) {
        categoriaServices.eliminar(id);
        return "redirect:/crud/categorias";
    }
}
