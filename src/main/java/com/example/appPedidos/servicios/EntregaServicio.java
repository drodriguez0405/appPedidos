package com.example.appPedidos.servicios;

import com.example.appPedidos.repositorios.IEntregadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntregaServicio {
    @Autowired
    IEntregadoRepositorio repositorio;
}
