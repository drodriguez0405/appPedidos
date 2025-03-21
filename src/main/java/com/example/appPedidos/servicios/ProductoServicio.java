package com.example.appPedidos.servicios;

import com.example.appPedidos.repositorios.IProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServicio {
    @Autowired
    IProductoRepositorio repositorio;
}
