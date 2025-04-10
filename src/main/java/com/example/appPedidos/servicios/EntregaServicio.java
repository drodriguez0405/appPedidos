package com.example.appPedidos.servicios;

import com.example.appPedidos.modelos.Entrega;
import com.example.appPedidos.repositorios.IEntregadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntregaServicio {
    @Autowired
    IEntregadoRepositorio repositorio;

    // Guardar
    public Entrega guardarEntrega(Entrega datosEntrega) throws Exception {
        try {
            return this.repositorio.save(datosEntrega);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar todas las entregas
    public List<Entrega> buscarTodasEntregas() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar por ID
    public Entrega buscarEntregaPorId(Integer idEntrega) throws Exception {
        try {
            Optional<Entrega> entregaBuscada = this.repositorio.findById(idEntrega);
            if (entregaBuscada.isPresent()) {
                return entregaBuscada.get();
            } else {
                throw new Exception("la entrega consultada no esta en BD");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Modificar entrega por ID
    public Entrega modificarEntrega(Integer id, Entrega datosEntrega) throws Exception {
        try {
            Optional<Entrega> entregaBuscada = this.repositorio.findById(id);
            if (entregaBuscada.isPresent()) {
                entregaBuscada.get().setFechaEntrega(datosEntrega.getFechaEntrega());
                entregaBuscada.get().setEstadoEntrega(datosEntrega.getEstadoEntrega());
                return this.repositorio.save(entregaBuscada.get());
            } else {
                throw new Exception("entrega no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar por ID
    public boolean eliminarEntrega(Integer id) throws Exception {
        try {
            Optional<Entrega> entregaBuscada = this.repositorio.findById(id);
            if (entregaBuscada.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception("entrega no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
