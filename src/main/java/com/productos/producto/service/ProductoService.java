package com.productos.producto.service;

import com.productos.producto.model.Producto;
import com.productos.producto.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public Iterable<Producto> buscarProductos() {
        return productoRepository.findAll();
    }

    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Optional<Producto> buscarProductoPorId(Long id) {
        return productoRepository.findById(id);
    }

    public Optional<Producto> buscarPorNombre(String nombre) {
        return productoRepository.findByNombre(nombre);
    }

    public Producto actualizarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
    
}
