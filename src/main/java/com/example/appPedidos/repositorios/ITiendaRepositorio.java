package com.example.appPedidos.repositorios;

import com.example.appPedidos.modelos.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITiendaRepositorio extends JpaRepository<Tienda, Integer> {
}
