package com.tec.azuay.edu.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.tec.azuay.edu.models.entity.Productos;

public interface IProductosDao extends CrudRepository<Productos, Long> {

}
