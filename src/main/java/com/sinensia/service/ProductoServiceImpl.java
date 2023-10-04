package com.sinensia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinensia.dao.ProductoDao;
import com.sinensia.model.Producto;

/**
 * Realizamos todos los metodos implementads de la interfaz, desde el dao
 * accedemos a los CRUD
 * 
 * @see com.sinensia.service.ProductoService
 * @see com.sinensia.controller.ProductoController
 */
@Service
public class ProductoServiceImpl implements ProductoService {

	/**
	 * Inyectamos nuestro repositorio
	 */
	@Autowired
	private ProductoDao dao;

	/**
	 * 
	 * @return List<Pedido>
	 */
	@Override
	public List<Producto> getAll() {
		return dao.findAll();
	}

	/**
	 * 
	 * @param codigoProducto
	 * @param producto
	 * @return Producto
	 */
	public Producto update(Producto producto) {
		return dao.save(producto);

	}

	@Override
	public double getPrice(int codigo_producto) {
		Producto producto = dao.findById(codigo_producto)
				.orElseThrow(() -> new IllegalArgumentException("Codigo no valido"));
		return producto.getPrecioUnitario();
	}

}
