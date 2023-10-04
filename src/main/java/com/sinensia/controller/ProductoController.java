package com.sinensia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	public List<Producto> getAll() {
		return service.getAll();
	}

	@GetMapping(value = "producto/{codigoProducto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public double getPrice(@PathVariable("codigoProducto") int codigoProducto) {
		return service.getPrice(codigoProducto);
	}

	@PutMapping("producto")
	public ResponseEntity<Producto> update(@RequestBody Producto producto) {
		Producto productoActualizado = service.update(producto);
		if (productoActualizado != null) {
			return ResponseEntity.ok(productoActualizado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
