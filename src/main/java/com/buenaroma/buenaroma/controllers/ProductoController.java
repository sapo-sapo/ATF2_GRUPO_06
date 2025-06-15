package com.buenaroma.buenaroma.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.buenaroma.buenaroma.entities.Categoria;
import com.buenaroma.buenaroma.entities.Producto;
import com.buenaroma.buenaroma.services.CategoriaServices;
import com.buenaroma.buenaroma.services.ProductoServices;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("crud/productos")
public class ProductoController {
    private final ProductoServices productoServices;
    private final CategoriaServices categoriaServices;

    @GetMapping
    public String mostrarProducto(Model model) {
        model.addAttribute("mostrar", productoServices.obtenerTodos());
        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", categoriaServices.obtenerTodos());
        return "crud/productos";
    }

    @PostMapping("/guardarProductos")
    public String guardarProducto(@ModelAttribute Producto producto) {
        productoServices.actualizar(producto);
        return "redirect:/crud/productos";
    }

    @GetMapping("/editarProductos")
    public String editarProducto(@RequestParam("id") int id, Model model) {
        model.addAttribute("producto", productoServices.obtenerUno(id));
        model.addAttribute("mostrar", productoServices.obtenerTodos());
        model.addAttribute("categorias", categoriaServices.obtenerTodos());
        return "crud/productos";
    }

    @PostMapping("/eliminarProductos")
    public String eliminarProducto(@RequestParam("id") Integer id) {
        productoServices.eliminar(id);
        return "redirect:/crud/productos";
    }
}
