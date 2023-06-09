package com.tec.azuay.edu.models.services;

import java.util.List;

import com.tec.azuay.edu.models.entity.Productos;

public interface IServicioProductos {
	
	public List<Productos> ListAll();
	
	public Productos saveProducto(Productos productos);
	
	public Productos findProductoById(Long id_producto);
	
	public void DeleteProducto(Long id_producto);
}
