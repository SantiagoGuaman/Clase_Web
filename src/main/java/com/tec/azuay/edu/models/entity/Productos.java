package com.tec.azuay.edu.models.entity;

import java.io.Serializable;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "producto")
public class Productos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7499579449276864118L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_producto;
	
	private String descripcion;
	private Double precio;
	
	@ManyToOne ( cascade = CascadeType.ALL)
	@JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    
	private Categorias categoria;
	
	@ManyToOne ( cascade = CascadeType.ALL)
	@JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor")
	private Proveedores proveedor;

	public Long getId_producto() {
		return id_producto;
	}

	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Categorias getCategoria() {
		return categoria;
	}

	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}

	public Proveedores getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedores proveedor) {
		this.proveedor = proveedor;
	}
}
