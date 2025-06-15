package com.buenaroma.buenaroma.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.buenaroma.buenaroma.entities.Producto;
import com.buenaroma.buenaroma.repositories.ProductoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoServices {
    private final ProductoRepository productoRepository;

    public Producto obtenerUno(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    public List<Producto> obtenerTodos(){
        return productoRepository.findAll();
    }
    
    public Producto actualizar(Producto producto){
        return productoRepository.save(producto);
    }
    
     public void eliminar(Integer id) {
        productoRepository.deleteById(id);
    }
}
