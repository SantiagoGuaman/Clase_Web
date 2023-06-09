package com.tec.azuay.edu.models.services;

import java.util.List;

import com.tec.azuay.edu.models.entity.Categorias;

public interface IServicioCategorias {
	
	public List<Categorias> ListAll();
	
	public Categorias saveCategoria(Categorias categorias);
	
	public Categorias findCategoriaById(Long id_categoria);
	
	public void DeleteCategoria(Long id_categoria);
}
