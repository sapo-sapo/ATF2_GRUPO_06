package com.buenaroma.buenaroma.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.buenaroma.buenaroma.entities.Categoria;
import com.buenaroma.buenaroma.repositories.CategoriaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaServices {
    private final CategoriaRepository categoriaRepository;

    public Categoria obtenerUno(Integer id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public List<Categoria> obtenerTodos(){
        return categoriaRepository.findAll();
    }
    
    public Categoria actualizar(Categoria categoria){
        return categoriaRepository.save(categoria);
    }
    
     public void eliminar(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
