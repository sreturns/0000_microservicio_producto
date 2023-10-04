package com.sinensia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.exceptions.ProductNotFoundException;
import com.sinensia.model.Producto;
import com.sinensia.service.ProductoService;

/**
 * El @RestController que utilizamos para acceder a los metodos Http
 * 
 * @author Sergio
 * @see com.sinensia.service.ProductoServiceImpl
 * @see com.sinensia.service.ProductoService
 * @see com.sinensia.model.Producto
 */
@RestController
public class ProductoController {

	@Autowired
	private ProductoService service;

	@GetMapping(value = "producto", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAll() {
		List<Producto> productos = service.getAll();

		if (productos != null) {
			return ResponseEntity.ok(productos);

		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No hay productos");
		}
	}

	@GetMapping(value = "producto/{codigoProducto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getPrice(@PathVariable("codigoProducto") int codigoProducto) {
		try {
			if (codigoProducto < 0) {
				throw new IllegalArgumentException("Parametro no valido");
			}

			return ResponseEntity.ok(service.getPrice(codigoProducto));

		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Parametros no validos");
		}
	}

	@PutMapping("producto")
	public ResponseEntity<?> update(@RequestBody Producto producto) {
		Producto productoActualizado = null;

		try {
			if (producto == null || producto.getProducto().isEmpty() || producto.getPrecioUnitario() < 0
					|| producto.getStock() <= 0) {

				throw new IllegalArgumentException("Parametros no validos");
			}

			productoActualizado = service.update(producto);

			if (productoActualizado == null) {
				throw new ProductNotFoundException("Producto no encontrado");

			}

		} catch (ProductNotFoundException | IllegalArgumentException e) {
			System.out.println("Error " + e);
		}
		return ResponseEntity.ok(productoActualizado);
	}
}
