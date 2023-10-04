package com.sinensia.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinensia.model.Producto;

/**
 * Implementamos la especificacion de JpaRepository
 * 
 * @see com.sinensia.service.ProductoServiceImpl
 */
public interface ProductoDao extends JpaRepository<Producto, Integer> {

}
