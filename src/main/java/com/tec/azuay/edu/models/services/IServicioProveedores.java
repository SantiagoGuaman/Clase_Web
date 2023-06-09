package com.tec.azuay.edu.models.services;

import java.util.List;

import com.tec.azuay.edu.models.entity.Proveedores;

public interface IServicioProveedores {
	
	public List<Proveedores> ListAll();
	
	public Proveedores saveProveedor(Proveedores proveedores);
	
	public Proveedores findProveedorById(Long id_proveedor);
	
	public void DeleteProveedor(Long id_proveedor);
	
}
