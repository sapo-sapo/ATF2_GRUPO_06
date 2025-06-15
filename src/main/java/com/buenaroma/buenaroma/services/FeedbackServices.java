package com.buenaroma.buenaroma.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.buenaroma.buenaroma.entities.Feedback;
import com.buenaroma.buenaroma.repositories.FeedbackRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FeedbackServices {
    private final FeedbackRepository feedbackRepository;

    public Feedback obtenerUno(Integer id) {
        return feedbackRepository.findById(id).orElse(null);
    }
    
    public List<Feedback> obtenerTodos(){
        return feedbackRepository.findAll();
    }

    public Feedback actualizar(Feedback feedback){
        return feedbackRepository.save(feedback);
    }
    
     public void eliminar(Integer id) {
        feedbackRepository.deleteById(id);
    }
}
