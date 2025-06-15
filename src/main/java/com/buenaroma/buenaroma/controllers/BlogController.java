package com.buenaroma.buenaroma.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.buenaroma.buenaroma.entities.Blog;
import com.buenaroma.buenaroma.services.BlogServices;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("crud/blogs")
public class BlogController {
    private final BlogServices blogServices;

    @GetMapping
    public String mostrarBlog(Model model) {
        model.addAttribute("mostrar", blogServices.obtenerTodos());
        model.addAttribute("blog", new Blog());
        return "crud/blogs";
    }

    @PostMapping("/guardarBlogs")
    public String guardarBlog(@ModelAttribute Blog blog) {
        blogServices.actualizar(blog);
        return "redirect:/crud/blogs";
    }

    @GetMapping("/editarBlogs")
    public String editarBlog(@RequestParam("id") int id, Model model) {
        model.addAttribute("blog", blogServices.obtenerUno(id));
        model.addAttribute("mostrar", blogServices.obtenerTodos());
        return "crud/blogs";
    }

    @PostMapping("/eliminarBlogs")
    public String eliminarBlog(@RequestParam("id") Integer id) {
        blogServices.eliminar(id);
        return "redirect:/crud/blogs";
    }
}
