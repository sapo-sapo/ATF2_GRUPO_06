package com.buenaroma.buenaroma.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Correo_Electronico")
    private String correo;
    @Column(name = "Contreseña")
    private String contraseña;
    @Column(name = "Rol")
    private String rol;
}