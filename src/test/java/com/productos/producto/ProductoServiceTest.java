package com.productos.producto;
import com.productos.producto.service.ProductoService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Optional;
import java.util.List;

import com.productos.producto.model.Producto;
import com.productos.producto.repository.ProductoRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class ProductoServiceTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

    private Producto producto;

    @BeforeEach
    public void setUp() {
        producto = new Producto();
        producto.setId(1L);
        producto.setNombre("Producto de prueba");
        producto.setDescripcion("Descripción de prueba");
        producto.setPrecio(99.99);
        producto.setStock(50);
        producto.setCategoria("Categoria de prueba");
        producto.setMarca("Marca de prueba");
        producto.setImagen("imagen.jpg");
    }

    @Test
    public void testBuscarProductos() {
        when(productoRepository.findAll()).thenReturn(List.of(producto));

        Iterable<Producto> productos = productoService.buscarProductos();

        assertEquals(1, ((List<Producto>) productos).size());
    }

    @Test
    public void testGuardarProducto() {
        when(productoRepository.save(producto)).thenReturn(producto);

        Producto savedProducto = productoService.guardarProducto(producto);

        assertEquals(producto, savedProducto);
    }

    @Test
    public void testBuscarProductoPorId() {
        when(productoRepository.findById(1L)).thenReturn(Optional.of(producto));

        Optional<Producto> foundProducto = productoService.buscarProductoPorId(1L);

        assertEquals(producto, foundProducto.get());
    }

    @Test
    public void testBuscarPorNombre() {
        when(productoRepository.findByNombre("Producto de prueba")).thenReturn(Optional.of(producto));

        Optional<Producto> foundProducto = productoService.buscarPorNombre("Producto de prueba");

        assertEquals(producto, foundProducto.get());
    }

    @Test
    public void testActualizarProducto() {
        when(productoRepository.save(producto)).thenReturn(producto);

        Producto updatedProducto = productoService.actualizarProducto(producto);

        assertEquals(producto, updatedProducto);
    }

    @Test
    public void testEliminarProducto() {
        doNothing().when(productoRepository).deleteById(1L);

        productoService.eliminarProducto(1L);

        verify(productoRepository, times(1)).deleteById(1L);
    }
}
