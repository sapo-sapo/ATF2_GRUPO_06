package com.buenaroma.buenaroma.entities;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Integer id;
    @Column(name = "fecha_hora")
    private LocalDate fecha;
    @Column(name = "cantidad_personas")
    private Integer cantidad;
    private String estado;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
