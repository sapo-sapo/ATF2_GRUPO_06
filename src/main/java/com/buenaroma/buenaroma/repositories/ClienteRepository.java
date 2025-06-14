package com.buenaroma.buenaroma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buenaroma.buenaroma.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
