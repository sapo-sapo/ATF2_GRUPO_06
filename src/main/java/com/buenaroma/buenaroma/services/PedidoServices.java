package com.buenaroma.buenaroma.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.buenaroma.buenaroma.entities.Pedido;
import com.buenaroma.buenaroma.repositories.PedidoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoServices {
    private final PedidoRepository pedidoRepository;

    public Pedido obtenerUno(Integer id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public List<Pedido> obtenerTodos(){
        return pedidoRepository.findAll();
    }
    
    public Pedido actualizar(Pedido pedido){
        return pedidoRepository.save(pedido);
    }
    
     public void eliminar(Integer id) {
        pedidoRepository.deleteById(id);
    }
}
