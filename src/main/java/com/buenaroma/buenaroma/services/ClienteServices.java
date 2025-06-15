package com.buenaroma.buenaroma.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.buenaroma.buenaroma.entities.Cliente;
import com.buenaroma.buenaroma.repositories.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServices {
    private final ClienteRepository clienteRepository;

    public Cliente obtenerUno(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Cliente> obtenerTodos(){
        return clienteRepository.findAll();
    }
    
    public Cliente actualizar(Cliente cliente){
        return clienteRepository.save(cliente);
    }
    
    public void eliminar(Integer id) {
        clienteRepository.deleteById(id);
    }
}
