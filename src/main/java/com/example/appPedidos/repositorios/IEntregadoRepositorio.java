package com.example.appPedidos.repositorios;

import com.example.appPedidos.modelos.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEntregadoRepositorio extends JpaRepository<Entrega, Integer> {
}
