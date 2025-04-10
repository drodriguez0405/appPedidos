package com.example.appPedidos.servicios;

import com.example.appPedidos.modelos.Detalle;
import com.example.appPedidos.modelos.Direccion;
import com.example.appPedidos.repositorios.IDetalleRepositorio;
import com.example.appPedidos.repositorios.IDireccionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DireccionServicio {
    @Autowired
    IDireccionRepositorio repositorio;

    // Guardar
    public Direccion guardarDireccion(Direccion datosDireccion) throws Exception {
        try {
            return this.repositorio.save(datosDireccion);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar todas las direcciones
    public List<Direccion> buscarTodasDirecciones() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar por ID
    public Direccion buscarDireccionPorId(Integer idDireccion) throws Exception {
        try {
            Optional<Direccion> direccionBuscada = this.repositorio.findById(idDireccion);
            if (direccionBuscada.isPresent()) {
                return direccionBuscada.get();
            } else {
                throw new Exception("la direccion consultada no esta en BD");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Modificar dirección por ID
    public Direccion modificarDireccion(Integer id, Direccion datosDireccion) throws Exception {
        try {
            Optional<Direccion> direccionBuscada = this.repositorio.findById(id);
            if (direccionBuscada.isPresent()) {
                direccionBuscada.get().setCalle(datosDireccion.getCalle());
                direccionBuscada.get().setCiudad(datosDireccion.getCiudad());
                direccionBuscada.get().setCodigoPostal(datosDireccion.getCodigoPostal());
                direccionBuscada.get().setPais(datosDireccion.getPais());
                return this.repositorio.save(direccionBuscada.get());
            } else {
                throw new Exception("direccion no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar por ID
    public boolean eliminarDireccion(Integer id) throws Exception {
        try {
            Optional<Direccion> direccionBuscada = this.repositorio.findById(id);
            if (direccionBuscada.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception("direccion no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
