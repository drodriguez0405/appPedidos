package com.example.appPedidos.repositorios;

import com.example.appPedidos.modelos.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDireccionRepositorio extends JpaRepository<Direccion, Integer> {
}
