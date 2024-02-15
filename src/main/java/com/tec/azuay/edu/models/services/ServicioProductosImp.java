package com.tec.azuay.edu.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tec.azuay.edu.models.dao.ICategoriasDao;
import com.tec.azuay.edu.models.dao.IProductosDao;
import com.tec.azuay.edu.models.dao.IProveedoresDao;
import com.tec.azuay.edu.models.entity.Categorias;
import com.tec.azuay.edu.models.entity.Productos;
import com.tec.azuay.edu.models.entity.Proveedores;

@Service
public class ServicioProductosImp implements IServicioProductos {
	
	@Autowired
	private IProductosDao productoDao;
	
	@Autowired
	private ICategoriasDao categoriaDao;
	
	@Autowired
	private IProveedoresDao proveedorDao;
	
	
	@Override
	@Transactional (readOnly = true)
	public List<Productos> ListAll() {
		return (List<Productos>) productoDao.findAll();
	}

	@Override
	@Transactional
	public Productos saveProducto(Productos productos) {
		
		Categorias cat = categoriaDao.findById(productos.getCategoria().getId_categoria()).orElse(null);
		Proveedores prov = proveedorDao.findById(productos.getProveedor().getId_proveedor()).orElse(null);
		
		productos.setCategoria(cat);
		productos.setProveedor(prov);
		
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
