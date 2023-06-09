package com.tec.azuay.edu.models.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "proveedor")
public class Proveedores implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6766714595874296406L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_proveedor;
	
	@Column (unique = true, length = 50)
	private String nombre;
	private String direccion;
	
	@Column (unique = true, length = 20)
	private String telefono;
	
	public Long getId_proveedor() {
		return id_proveedor;
	}
	public void setId_proveedor(Long id_proveedor) {
		this.id_proveedor = id_proveedor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
