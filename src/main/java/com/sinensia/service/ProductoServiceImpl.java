package com.sinensia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinensia.dao.ProductoDao;
import com.sinensia.exceptions.ProductNotFoundException;
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
	public double getPrice(int codigoProducto) {
		Producto producto = null;

		try {
			producto = dao.findById(codigoProducto)
					.orElseThrow(() -> new ProductNotFoundException("Producto no encontrado"));
		} catch (ProductNotFoundException e) {
			System.out.println("Error al encontrar el producto" + e);
		}
		return producto.getPrecioUnitario();
	}

}
