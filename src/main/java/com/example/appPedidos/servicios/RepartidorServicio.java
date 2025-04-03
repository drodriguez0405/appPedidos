package com.example.appPedidos.servicios;

import com.example.appPedidos.modelos.Repartidor;
import com.example.appPedidos.repositorios.IRepartidorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepartidorServicio {
    @Autowired
    IRepartidorRepositorio repositorio;

    // Guardar
    public Repartidor guardarRepartidor(Repartidor datosRepartidor) throws Exception {
        try {
            return this.repositorio.save(datosRepartidor);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar todos los repartidores
    public List<Repartidor> buscarTodosRepartidores() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar por ID
    public Repartidor buscarRepartidorPorId(Integer idRepartidor) throws Exception {
        try {
            Optional<Repartidor> repartidorBuscado = this.repositorio.findById(idRepartidor);
            if (repartidorBuscado.isPresent()) {
                return repartidorBuscado.get();
            } else {
                throw new Exception("El repartidor consultado no está en BD");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Modificar repartidor por ID
    public Repartidor modificarRepartidor(Integer id, Repartidor datosRepartidor) throws Exception {
        try {
            Optional<Repartidor> repartidorBuscado = this.repositorio.findById(id);
            if (repartidorBuscado.isPresent()) {
                repartidorBuscado.get().setNombre(datosRepartidor.getNombre());
                repartidorBuscado.get().setTelefono(datosRepartidor.getTelefono());
                repartidorBuscado.get().setCorreo(datosRepartidor.getCorreo());
                repartidorBuscado.get().setVehiculo(datosRepartidor.getVehiculo());
                return this.repositorio.save(repartidorBuscado.get());
            } else {
                throw new Exception("Repartidor no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar por ID
    public boolean eliminarRepartidor(Integer id) throws Exception {
        try {
            Optional<Repartidor> repartidorBuscado = this.repositorio.findById(id);
            if (repartidorBuscado.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception("Repartidor no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
