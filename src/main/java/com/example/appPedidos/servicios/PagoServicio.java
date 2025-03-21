package com.example.appPedidos.servicios;

import com.example.appPedidos.repositorios.IPagoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagoServicio {
    @Autowired
    IPagoRepositorio repositorio;
}
