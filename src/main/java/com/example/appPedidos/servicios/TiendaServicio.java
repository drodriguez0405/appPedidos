package com.example.appPedidos.servicios;

import com.example.appPedidos.repositorios.ITiendaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TiendaServicio {
    @Autowired
    ITiendaRepositorio repositorio;
}
