package com.buenaroma.buenaroma.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "pedidos")
public class Pedido {
    @Column(name = "id_pedido")
    private Integer id;
    private LocalDate fecha;
    private BigDecimal total;
    private String estado;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
}
