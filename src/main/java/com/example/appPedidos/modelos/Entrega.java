package com.example.appPedidos.modelos;

import com.example.appPedidos.ayudas.enums.EntregaEstadoEnum;

public class Entrega {
    private Integer id;
    private String fechaEntrega;
    private EntregaEstadoEnum estadoEntrega;

    public Entrega() {
    }

    public Entrega(Integer id, String fechaEntrega, EntregaEstadoEnum estadoEntrega) {
        this.id = id;
        this.fechaEntrega = fechaEntrega;
        this.estadoEntrega = estadoEntrega;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public EntregaEstadoEnum getEstadoEntrega() {
        return estadoEntrega;
    }

    public void setEstadoEntrega(EntregaEstadoEnum estadoEntrega) {
        this.estadoEntrega = estadoEntrega;
    }
}
