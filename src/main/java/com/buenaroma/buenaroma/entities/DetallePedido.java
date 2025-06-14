package com.buenaroma.buenaroma.entities;

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
@Table(name = "detalles_pedidos")
public class DetallePedido {
    @Column(name = "id_detalle_pedido")
    private Integer id;
    private String cantidad;
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
}
