package com.example.appPedidos.repositorios;

import com.example.appPedidos.modelos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepositorio extends JpaRepository<Producto, Integer> {
}
