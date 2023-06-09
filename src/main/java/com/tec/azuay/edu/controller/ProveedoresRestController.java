package com.tec.azuay.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tec.azuay.edu.models.entity.Proveedores;
import com.tec.azuay.edu.models.services.IServicioProveedores;

@RestController
@RequestMapping ("/api")
public class ProveedoresRestController {
	
	@Autowired
	private IServicioProveedores proveedorService;
	
	@GetMapping ("/proveedores")
	public List<Proveedores> index() {
		return proveedorService.ListAll();
	}
	
	@GetMapping ("/proveedores/{id}")
	public Proveedores findById(@PathVariable("id") Long id_proveedor) {
		return proveedorService.findProveedorById(id_proveedor);
	}
	
	@PostMapping ("/proveedores")
	@ResponseStatus (HttpStatus.CREATED)
	public Proveedores createProveedor(@RequestBody Proveedores proveedores) {
		return proveedorService.saveProveedor(proveedores);
	}
	
	@PutMapping ("/proveedores/{id}")
	public Proveedores updateProveedor(@RequestBody Proveedores proveedores, @PathVariable("id") Long id_proveedor) {
		Proveedores proveedorActual = proveedorService.findProveedorById(id_proveedor);
		proveedorActual.setNombre(proveedores.getNombre());
		proveedorActual.setTelefono(proveedores.getTelefono());
		proveedorActual.setDireccion(proveedores.getDireccion());
		
		return  proveedorService.saveProveedor(proveedorActual);
	}
	
	@DeleteMapping ("/proveedores/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void deleteProveedor(@PathVariable("id") Long id_proveedor) {
		proveedorService.DeleteProveedor(id_proveedor);
	}
}
