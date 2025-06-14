package com.buenaroma.buenaroma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buenaroma.buenaroma.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
