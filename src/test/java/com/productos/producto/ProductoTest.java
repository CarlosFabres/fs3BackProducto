package com.productos.producto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.productos.producto.model.Producto;

import org.junit.jupiter.api.Test;

public class ProductoTest {

    @Test
    public void testGettersSetters() {
        Producto producto = new Producto();

        producto.setId(1L);
        producto.setNombre("Producto de prueba");
        producto.setDescripcion("Descripción de prueba");
        producto.setPrecio(99.99);
        producto.setStock(50);
        producto.setCategoria("Categoria de prueba");
        producto.setMarca("Marca de prueba");
        producto.setImagen("imagen.jpg");

        assertEquals(1L, producto.getId());
        assertEquals("Producto de prueba", producto.getNombre());
        assertEquals("Descripción de prueba", producto.getDescripcion());
        assertEquals(99.99, producto.getPrecio());
        assertEquals(50, producto.getStock());
        assertEquals("Categoria de prueba", producto.getCategoria());
        assertEquals("Marca de prueba", producto.getMarca());
        assertEquals("imagen.jpg", producto.getImagen());
    }
}
