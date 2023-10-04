package com.sinensia.service;

import java.util.List;

import com.sinensia.model.Producto;

/**
 * Interfaz que implementaremos en nuestro @Service
 * 
 * @see com.sinensia.service.ProductoServiceImpl
 */
public interface ProductoService {

	List<Producto> getAll();

	public Producto update(Producto producto);

	double getPrice(int codigo_producto);

}
