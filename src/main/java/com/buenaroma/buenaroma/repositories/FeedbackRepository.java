package com.buenaroma.buenaroma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buenaroma.buenaroma.entities.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

}
