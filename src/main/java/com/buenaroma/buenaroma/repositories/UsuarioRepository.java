package com.buenaroma.buenaroma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buenaroma.buenaroma.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
