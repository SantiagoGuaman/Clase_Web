package com.tec.azuay.edu.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tec.azuay.edu.models.dao.ICategoriasDao;
import com.tec.azuay.edu.models.entity.Categorias;

@Service
public class ServicioCategoriasImp implements IServicioCategorias {

	@Autowired
	private ICategoriasDao cateogoriaDao;
	
	@Override
	@Transactional (readOnly = true)
	public List<Categorias> ListAll() {
		return (List<Categorias>) cateogoriaDao.findAll();
	}

	@Override
	@Transactional
	public Categorias saveCategoria(Categorias categoria) {
		return cateogoriaDao.save(categoria);
	}

	@Override
	@Transactional (readOnly = true)
	public Categorias findCategoriaById(Long id_categoria) {
		return cateogoriaDao.findById(id_categoria).orElse(null);
	}

	@Override
	@Transactional
	public void DeleteCategoria(Long id_categoria) {
		cateogoriaDao.deleteById(id_categoria);
	}

}
