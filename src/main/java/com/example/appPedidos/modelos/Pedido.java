package com.example.appPedidos.modelos;

import com.example.appPedidos.ayudas.enums.PedidoEnum;

public class Pedido {
    private Integer id;
    private String fecha;
    private double total;
    private PedidoEnum estado;

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
