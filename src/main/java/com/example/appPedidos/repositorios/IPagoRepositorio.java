package com.example.appPedidos.repositorios;

import com.example.appPedidos.modelos.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPagoRepositorio extends JpaRepository<Pago, Integer> {
}
