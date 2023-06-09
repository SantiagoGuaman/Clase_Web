package com.tec.azuay.edu.models.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "categoria")
public class Categorias implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7307718914813845186L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_categoria;
	
	@Column (unique = true)
	private String descripcion;

	public Long getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Long id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
