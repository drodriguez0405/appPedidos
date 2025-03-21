package com.example.appPedidos.repositorios;

import com.example.appPedidos.modelos.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPedidoRepositorio extends JpaRepository<Pedido, Integer> {
}
