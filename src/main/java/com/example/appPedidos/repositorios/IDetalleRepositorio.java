package com.example.appPedidos.repositorios;

import com.example.appPedidos.modelos.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetalleRepositorio extends JpaRepository<Detalle, Integer> {
}
