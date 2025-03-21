package com.example.appPedidos.servicios;

import com.example.appPedidos.repositorios.IPedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServicio {
    @Autowired
    IPedidoRepositorio repositorio;
}
