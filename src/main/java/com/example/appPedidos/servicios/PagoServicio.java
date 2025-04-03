package com.example.appPedidos.servicios;

import com.example.appPedidos.modelos.Pago;
import com.example.appPedidos.repositorios.IPagoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoServicio {
    @Autowired
    IPagoRepositorio repositorio;

    // Guardar
    public Pago guardarPago(Pago datosPago) throws Exception {
        try {
            return this.repositorio.save(datosPago);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar todos los pagos
    public List<Pago> buscarTodosPagos() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar por ID
    public Pago buscarPagoPorId(Integer idPago) throws Exception {
        try {
            Optional<Pago> pagoBuscado = this.repositorio.findById(idPago);
            if (pagoBuscado.isPresent()) {
                return pagoBuscado.get();
            } else {
                throw new Exception("El pago consultado no está en BD");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Modificar pago por ID
    public Pago modificarPago(Integer id, Pago datosPago) throws Exception {
        try {
            Optional<Pago> pagoBuscado = this.repositorio.findById(id);
            if (pagoBuscado.isPresent()) {
                pagoBuscado.get().setFechaPago(datosPago.getFechaPago());
                pagoBuscado.get().setEstado(datosPago.getEstado());
                pagoBuscado.get().setMetodo(datosPago.getMetodo());
                return this.repositorio.save(pagoBuscado.get());
            } else {
                throw new Exception("Pago no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar por ID
    public boolean eliminarPago(Integer id) throws Exception {
        try {
            Optional<Pago> pagoBuscado = this.repositorio.findById(id);
            if (pagoBuscado.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception("Pago no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
