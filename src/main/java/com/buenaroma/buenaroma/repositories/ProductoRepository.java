package com.buenaroma.buenaroma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buenaroma.buenaroma.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
