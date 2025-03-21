package com.example.appPedidos.repositorios;

import com.example.appPedidos.modelos.Repartidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepartidorRepositorio extends JpaRepository<Repartidor, Integer> {
}
