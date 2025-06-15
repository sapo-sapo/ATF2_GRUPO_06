package com.buenaroma.buenaroma.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.buenaroma.buenaroma.entities.Usuario;
import com.buenaroma.buenaroma.repositories.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServices {

    private final UsuarioRepository usuarioRepository;

    public Usuario obtenerUno(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario actualizar(Usuario usuario) {
        return usuarioRepository.save(usuario); 
    }

    public void eliminar(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
