package com.buenaroma.buenaroma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buenaroma.buenaroma.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
