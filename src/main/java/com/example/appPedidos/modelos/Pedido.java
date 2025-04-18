package com.example.appPedidos.modelos;

import com.example.appPedidos.ayudas.enums.PedidoEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "pedido_tabla")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer id;

    @Column(name = "fecha_pedido",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",nullable = false)
    private String fecha;

    @Column(name = "total_pedido",nullable = false)
    private double total;

    @Column(name = "estado", columnDefinition = "ENUM('pendiente', 'en camino', 'entregado') DEFAULT 'pendiente'")
    private PedidoEnum estado;

    @ManyToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario")
    @JsonBackReference
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "fk_pago", referencedColumnName = "id_pago")
    @JsonBackReference
    private Pago pago;

    @ManyToOne
    @JoinColumn(name = "fk_tienda", referencedColumnName = "id_tienda")
    @JsonBackReference
    private Tienda tienda;

    @ManyToOne
    @JoinColumn(name = "fk_detalle", referencedColumnName = "id_detalle")
    @JsonBackReference
    private Detalle detalle;

    public Pedido() {
    }

    public Pedido(Integer id, String fecha, double total, PedidoEnum estado) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public PedidoEnum getEstado() {
        return estado;
    }

    public void setEstado(PedidoEnum estado) {
        this.estado = estado;
    }
}
