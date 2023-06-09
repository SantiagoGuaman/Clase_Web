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

import com.tec.azuay.edu.models.entity.Categorias;
import com.tec.azuay.edu.models.services.IServicioCategorias;

@RestController
@RequestMapping ("/api")
public class CategoriasRestController {
	@Autowired
	private IServicioCategorias categoriaService;
	
	@GetMapping ("/categorias")
	public List<Categorias> index() {
		return categoriaService.ListAll();
	}
	
	@GetMapping ("/categorias/{id}")
	public Categorias findById(@PathVariable("id") Long id_categoria) {
		return categoriaService.findCategoriaById(id_categoria);
	}
	
	@PostMapping ("/categorias")
	@ResponseStatus (HttpStatus.CREATED)
	public Categorias createCategoria(@RequestBody Categorias categorias) {
		return categoriaService.saveCategoria(categorias);
	}
	
	@PutMapping ("/categorias/{id}")
	public Categorias updateCategoria(@RequestBody Categorias categorias, @PathVariable("id") Long id_categoria) {
		Categorias categoriaActual = categoriaService.findCategoriaById(id_categoria);
		categoriaActual.setDescripcion(categorias.getDescripcion());
		
		return  categoriaService.saveCategoria(categoriaActual);
	}
	
	@DeleteMapping ("/categorias/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void deleteProveedor(@PathVariable("id") Long id_categoria) {
		categoriaService.DeleteCategoria(id_categoria);
	}
}
