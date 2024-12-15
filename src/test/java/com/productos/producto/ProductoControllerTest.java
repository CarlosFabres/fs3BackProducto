package com.productos.producto;

import com.productos.producto.model.Producto;
import com.productos.producto.service.ProductoService;
import com.productos.producto.controller.ProductoController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductoControllerTest {

    @InjectMocks
    private ProductoController productoController;

    @Mock
    private ProductoService productoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void obtenerProductosDebeRetornarListaDeProductos() {
        // Arrange
        Producto producto1 = new Producto();
        Producto producto2 = new Producto();
        when(productoService.buscarProductos()).thenReturn(Arrays.asList(producto1, producto2));

        // Act
        ResponseEntity<Iterable<Producto>> response = productoController.obtenerProductos();

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, ((Iterable<Producto>) response.getBody()).spliterator().getExactSizeIfKnown());
        verify(productoService, times(1)).buscarProductos();
    }

    @Test
    void crearProductoDebeRetornarProductoCreado() {
        // Arrange
        Producto producto = new Producto();
        producto.setId(1L);
        when(productoService.guardarProducto(producto)).thenReturn(producto);

        // Act
        ResponseEntity<Producto> response = productoController.crearProducto(producto);

        // Assert
        assertNotNull(response);
        assertEquals(201, response.getStatusCodeValue());
        assertEquals(1L, response.getBody().getId());
        verify(productoService, times(1)).guardarProducto(producto);
    }

    @Test
    void obtenerProductoPorIdDebeRetornarProductoCuandoExiste() {
        // Arrange
        Producto producto = new Producto();
        producto.setId(1L);
        when(productoService.buscarProductoPorId(1L)).thenReturn(Optional.of(producto));

        // Act
        ResponseEntity<Producto> response = productoController.obtenerProductoPorId(1L);

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1L, response.getBody().getId());
        verify(productoService, times(1)).buscarProductoPorId(1L);
    }

    @Test
    void obtenerProductoPorIdDebeRetornarNotFoundCuandoNoExiste() {
        // Arrange
        when(productoService.buscarProductoPorId(1L)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Producto> response = productoController.obtenerProductoPorId(1L);

        // Assert
        assertNotNull(response);
        assertEquals(404, response.getStatusCodeValue());
        verify(productoService, times(1)).buscarProductoPorId(1L);
    }

    @Test
    void actualizarProductoDebeRetornarProductoActualizado() {
        // Arrange
        Producto producto = new Producto();
        producto.setId(1L);
        when(productoService.actualizarProducto(producto)).thenReturn(producto);

        // Act
        ResponseEntity<Producto> response = productoController.actualizarProducto(1L, producto);

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1L, response.getBody().getId());
        verify(productoService, times(1)).actualizarProducto(producto);
    }

    @Test
    void eliminarProductoDebeLlamarAlServicioYRetornarNoContent() {
        // Act
        ResponseEntity<Void> response = productoController.eliminarProducto(1L);

        // Assert
        assertNotNull(response);
        assertEquals(204, response.getStatusCodeValue());
        verify(productoService, times(1)).eliminarProducto(1L);
    }
}
