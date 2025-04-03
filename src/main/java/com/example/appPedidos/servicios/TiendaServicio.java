package com.example.appPedidos.servicios;

import com.example.appPedidos.modelos.Tienda;
import com.example.appPedidos.repositorios.ITiendaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TiendaServicio {
    @Autowired
    ITiendaRepositorio repositorio;

    // Guardar
    public Tienda guardarTienda(Tienda datosTienda) throws Exception {
        try {
            return this.repositorio.save(datosTienda);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar todas las tiendas
    public List<Tienda> buscarTodasTiendas() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar por ID
    public Tienda buscarTiendaPorId(Integer idTienda) throws Exception {
        try {
            Optional<Tienda> tiendaBuscada = this.repositorio.findById(idTienda);
            if (tiendaBuscada.isPresent()) {
                return tiendaBuscada.get();
            } else {
                throw new Exception("La tienda consultada no está en BD");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Modificar tienda por ID
    public Tienda modificarTienda(Integer id, Tienda datosTienda) throws Exception {
        try {
            Optional<Tienda> tiendaBuscada = this.repositorio.findById(id);
            if (tiendaBuscada.isPresent()) {
                tiendaBuscada.get().setDireccion(datosTienda.getDireccion());
                tiendaBuscada.get().setTelefono(datosTienda.getTelefono());
                tiendaBuscada.get().setCategoria(datosTienda.getCategoria());
                return this.repositorio.save(tiendaBuscada.get());
            } else {
                throw new Exception("Tienda no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar por ID
    public boolean eliminarTienda(Integer id) throws Exception {
        try {
            Optional<Tienda> tiendaBuscada = this.repositorio.findById(id);
            if (tiendaBuscada.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception("Tienda no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
