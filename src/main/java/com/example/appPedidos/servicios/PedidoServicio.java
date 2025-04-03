package com.example.appPedidos.servicios;

import com.example.appPedidos.modelos.Pedido;
import com.example.appPedidos.repositorios.IPedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServicio {
    @Autowired
    IPedidoRepositorio repositorio;

    // Guardar
    public Pedido guardarPedido(Pedido datosPedido) throws Exception {
        try {
            return this.repositorio.save(datosPedido);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar todos los pedidos
    public List<Pedido> buscarTodosPedidos() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar por ID
    public Pedido buscarPedidoPorId(Integer idPedido) throws Exception {
        try {
            Optional<Pedido> pedidoBuscado = this.repositorio.findById(idPedido);
            if (pedidoBuscado.isPresent()) {
                return pedidoBuscado.get();
            } else {
                throw new Exception("El pedido consultado no está en BD");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Modificar pedido por ID
    public Pedido modificarPedido(Integer id, Pedido datosPedido) throws Exception {
        try {
            Optional<Pedido> pedidoBuscado = this.repositorio.findById(id);
            if (pedidoBuscado.isPresent()) {
                pedidoBuscado.get().setFecha(datosPedido.getFecha());
                pedidoBuscado.get().setTotal(datosPedido.getTotal());
                pedidoBuscado.get().setEstado(datosPedido.getEstado());
                return this.repositorio.save(pedidoBuscado.get());
            } else {
                throw new Exception("Pedido no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar por ID
    public boolean eliminarPedido(Integer id) throws Exception {
        try {
            Optional<Pedido> pedidoBuscado = this.repositorio.findById(id);
            if (pedidoBuscado.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception("Pedido no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
