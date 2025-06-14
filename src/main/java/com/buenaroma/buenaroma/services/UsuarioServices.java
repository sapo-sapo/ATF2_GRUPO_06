package com.buenaroma.buenaroma.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.buenaroma.buenaroma.entities.Usuario;
import com.buenaroma.buenaroma.repositories.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service

@RequiredArgsConstructor
public class UsuarioServices {

    private final UsuarioRepository repository;

    public List<Usuario> select() {
        return repository.findAll();
    }

    public Usuario selectOne(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Usuario insertUpdate(Usuario Usuario) {
        return repository.save(Usuario);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
