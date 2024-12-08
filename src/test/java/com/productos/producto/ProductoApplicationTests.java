package com.productos.producto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import com.productos.producto.controller.ProductoController;

@SpringBootTest
class ProductoApplicationTests {

	@Autowired
	private ProductoController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
