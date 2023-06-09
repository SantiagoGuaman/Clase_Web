package com.tec.azuay.edu.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tec.azuay.edu.models.dao.IProductosDao;
import com.tec.azuay.edu.models.entity.Productos;

@Service
public class ServicioProductosImp implements IServicioProductos {
	
	@Autowired
	private IProductosDao productoDao;
	
	@Override
	@Transactional (readOnly = true)
	public List<Productos> ListAll() {
		return (List<Productos>) productoDao.findAll();
	}

	@Override
	@Transactional
	public Productos saveProducto(Productos productos) {
		return productoDao.save(productos);
	}

	@Override
	@Transactional (readOnly = true)
	public Productos findProductoById(Long id_producto) {
		return productoDao.findById(id_producto).orElse(null);
	}

	@Override
	@Transactional
	public void DeleteProducto(Long id_producto) {
		productoDao.deleteById(id_producto);
	}
}
