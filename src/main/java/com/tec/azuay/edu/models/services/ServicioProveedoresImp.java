package com.tec.azuay.edu.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tec.azuay.edu.models.dao.IProveedoresDao;
import com.tec.azuay.edu.models.entity.Proveedores;

@Service
public class ServicioProveedoresImp implements IServicioProveedores {

	@Autowired
	private IProveedoresDao proveedorDao;
	
	@Override
	@Transactional (readOnly = true)
	public List<Proveedores> ListAll() {
		return (List<Proveedores>) proveedorDao.findAll();
	}

	@Override
	@Transactional
	public Proveedores saveProveedor(Proveedores proveedores) {
		return proveedorDao.save(proveedores);
	}

	@Override
	@Transactional (readOnly = true)
	public Proveedores findProveedorById(Long id_proveedor) {
		return proveedorDao.findById(id_proveedor).orElse(null);
	}

	@Override
	@Transactional
	public void DeleteProveedor(Long id_proveedor) {
		proveedorDao.deleteById(id_proveedor);
	}

}
