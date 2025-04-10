package com.example.appPedidos.servicios;

import com.example.appPedidos.modelos.Detalle;
import com.example.appPedidos.repositorios.IDetalleRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleServicio {
    @Autowired
    IDetalleRepositorio repositorio;

    // Guardar
    public Detalle guardarDetalle(Detalle datosDetalle) throws Exception {
        try {
            return this.repositorio.save(datosDetalle);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar todos los detalles
    public List<Detalle> buscarTodosDetalles() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar por ID
    public Detalle buscarDetallePorId(Integer idDetalle) throws Exception {
        try {
            Optional<Detalle> detalleBuscado = this.repositorio.findById(idDetalle);
            if (detalleBuscado.isPresent()) {
                return detalleBuscado.get();
            } else {
                throw new Exception("el detalle consultado no esta en BD");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Modificar detalle por ID
    public Detalle modificarDetalle(Integer id, Detalle datosDetalle) throws Exception {
        try {
            Optional<Detalle> detalleBuscado = this.repositorio.findById(id);
            if (detalleBuscado.isPresent()) {
                detalleBuscado.get().setCantidad(datosDetalle.getCantidad());
                detalleBuscado.get().setSubtotal(datosDetalle.getSubtotal());
                return this.repositorio.save(detalleBuscado.get());
            } else {
                throw new Exception("detalle no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar por ID
    public boolean eliminarDetalle(Integer id) throws Exception {
        try {
            Optional<Detalle> detalleBuscado = this.repositorio.findById(id);
            if (detalleBuscado.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception("detalle no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
