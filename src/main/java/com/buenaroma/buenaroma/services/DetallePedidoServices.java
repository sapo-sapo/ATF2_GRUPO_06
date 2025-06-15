package com.buenaroma.buenaroma.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.buenaroma.buenaroma.entities.DetallePedido;
import com.buenaroma.buenaroma.repositories.DetallePedidoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DetallePedidoServices {
    private final DetallePedidoRepository detallePedidoRepository;

    public DetallePedido obtenerUno(Integer id) {
        return detallePedidoRepository.findById(id).orElse(null);
    }

    public List<DetallePedido> obtenerTodos(){
        return detallePedidoRepository.findAll();
    }

    public DetallePedido actualizar(DetallePedido detallePedido){
        return detallePedidoRepository.save(detallePedido);
    }
    
     public void eliminar(Integer id) {
        detallePedidoRepository.deleteById(id);
    }
}
