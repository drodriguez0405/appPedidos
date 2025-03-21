package com.example.appPedidos.modelos;

import com.example.appPedidos.ayudas.enums.PagoEstadoEnum;
import com.example.appPedidos.ayudas.enums.PagoMetodoEnum;

public class Pago {
    private Integer id;
    private String fechaPago;
    private PagoEstadoEnum estado;
    private PagoMetodoEnum metodo;

    public Pago() {
    }

    public Pago(Integer id, String fechaPago, PagoEstadoEnum estado, PagoMetodoEnum metodo) {
        this.id = id;
        this.fechaPago = fechaPago;
        this.estado = estado;
        this.metodo = metodo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public PagoEstadoEnum getEstado() {
        return estado;
    }

    public void setEstado(PagoEstadoEnum estado) {
        this.estado = estado;
    }

    public PagoMetodoEnum getMetodo() {
        return metodo;
    }

    public void setMetodo(PagoMetodoEnum metodo) {
        this.metodo = metodo;
    }
}
