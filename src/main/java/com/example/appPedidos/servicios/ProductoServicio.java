package com.example.appPedidos.servicios;

import com.example.appPedidos.modelos.Producto;
import com.example.appPedidos.repositorios.IProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio {
    @Autowired
    IProductoRepositorio repositorio;

    // Guardar
    public Producto guardarProducto(Producto datosProducto) throws Exception {
        try {
            return this.repositorio.save(datosProducto);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar todos los productos
    public List<Producto> buscarTodosProductos() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar por ID
    public Producto buscarProductoPorId(Integer idProducto) throws Exception {
        try {
            Optional<Producto> productoBuscado = this.repositorio.findById(idProducto);
            if (productoBuscado.isPresent()) {
                return productoBuscado.get();
            } else {
                throw new Exception("el producto consultado no esta en BD");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Modificar producto por ID
    public Producto modificarProducto(Integer id, Producto datosProducto) throws Exception {
        try {
            Optional<Producto> productoBuscado = this.repositorio.findById(id);
            if (productoBuscado.isPresent()) {
                productoBuscado.get().setNombre(datosProducto.getNombre());
                productoBuscado.get().setPrecio(datosProducto.getPrecio());
                productoBuscado.get().setDescripcion(datosProducto.getDescripcion());
                return this.repositorio.save(productoBuscado.get());
            } else {
                throw new Exception("producto no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar por ID
    public boolean eliminarProducto(Integer id) throws Exception {
        try {
            Optional<Producto> productoBuscado = this.repositorio.findById(id);
            if (productoBuscado.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception("producto no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
