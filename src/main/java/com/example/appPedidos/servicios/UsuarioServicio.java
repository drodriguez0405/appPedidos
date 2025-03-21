package com.example.appPedidos.servicios;

import com.example.appPedidos.repositorios.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {
    @Autowired
    IUsuarioRepositorio repositorio;
}
