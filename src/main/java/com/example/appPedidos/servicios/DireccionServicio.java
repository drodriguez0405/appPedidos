package com.example.appPedidos.servicios;

import com.example.appPedidos.repositorios.IDetalleRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DireccionServicio {
    @Autowired
    IDetalleRepositorio repositorio;
}
