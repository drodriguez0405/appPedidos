package com.example.appPedidos.servicios;

import com.example.appPedidos.repositorios.IRepartidorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepartidorServicio {
    @Autowired
    IRepartidorRepositorio repositorio;
}
