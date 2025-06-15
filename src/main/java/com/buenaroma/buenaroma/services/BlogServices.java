package com.buenaroma.buenaroma.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.buenaroma.buenaroma.entities.Blog;
import com.buenaroma.buenaroma.repositories.BlogRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogServices {
    private final BlogRepository blogRepository;

    public Blog obtenerUno(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    public List<Blog> obtenerTodos(){
        return blogRepository.findAll();
    }
    
    public Blog actualizar(Blog blog){
        return blogRepository.save(blog);
    }
    
     public void eliminar(Integer id) {
        blogRepository.deleteById(id);
    }
}
