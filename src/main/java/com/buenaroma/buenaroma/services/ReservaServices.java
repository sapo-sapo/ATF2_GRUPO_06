package com.buenaroma.buenaroma.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.buenaroma.buenaroma.entities.Reserva;
import com.buenaroma.buenaroma.repositories.ReservaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservaServices {
    private final ReservaRepository reservaRepository;

    public Reserva obtenerUno(Integer id) {
        return reservaRepository.findById(id).orElse(null);
    }

    public List<Reserva> obtenerTodos(){
        return reservaRepository.findAll();
    }
    
    public Reserva actualizar(Reserva Reserva){
        return reservaRepository.save(Reserva);
    }
    
     public void eliminar(Integer id) {
        reservaRepository.deleteById(id);
    }
}
