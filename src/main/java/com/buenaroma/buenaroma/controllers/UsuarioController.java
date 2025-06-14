/*
 * package com.buenaroma.buenaroma.controllers;
 * 
 * import org.springframework.stereotype.Controller;
 * import org.springframework.ui.Model;
 * import org.springframework.web.bind.annotation.GetMapping;
 * import org.springframework.web.bind.annotation.ModelAttribute;
 * import org.springframework.web.bind.annotation.PostMapping;
 * import org.springframework.web.bind.annotation.RequestMapping;
 * import org.springframework.web.bind.annotation.RequestParam;
 * 
 * import com.buenaroma.buenaroma.entities.Usuario;
 * import com.buenaroma.buenaroma.services.UsuarioServices;
 * 
 * import lombok.RequiredArgsConstructor;
 * 
 * @Controller
 * 
 * @RequiredArgsConstructor
 * 
 * @RequestMapping("")
 * 
 * public class UsuarioController {
 * private final UsuarioServices services;
 * 
 * @GetMapping
 * public String mostrar(Model model) {
 * model.addAttribute("mostrar", services.select());
 * model.addAttribute("usuario", new Usuario());
 * return "";
 * }
 * 
 * @PostMapping("/save")
 * public String guardar(@ModelAttribute Usuario usuario) {
 * services.insertUpdate(usuario);
 * return "redirect:";
 * }
 * 
 * @GetMapping("/edit")
 * public String editar(@RequestParam("id") int id, Model model) {
 * model.addAttribute("usuario", services.selectOne(id));
 * model.addAttribute("lista", services.select());
 * return "";
 * }
 * 
 * @PostMapping("/delete")
 * public String eliminar(@RequestParam("id") Integer id) {
 * services.delete(id);
 * return "redirect:";
 * }
 * }
 */
