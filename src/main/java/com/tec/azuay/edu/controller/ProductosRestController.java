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

import com.tec.azuay.edu.models.entity.Productos;
import com.tec.azuay.edu.models.services.IServicioProductos;

@RestController
@RequestMapping ("/api")
public class ProductosRestController {

	@Autowired
	private IServicioProductos productoService;
	
	@GetMapping ("/productos")
	public List<Productos> index() {
		return productoService.ListAll();
	}
	
	@GetMapping ("/productos/{id}")
	public Productos findById(@PathVariable("id") Long id_productos) {
		return productoService.findProductoById(id_productos);
	}
	
	@PostMapping ("/productos")
	@ResponseStatus (HttpStatus.CREATED)
	public Productos createProducto(@RequestBody Productos productos) {
		return productoService.saveProducto(productos);
	}
	
	@PutMapping ("/productos/{id}")
	public Productos updateProducto(@RequestBody Productos productos, @PathVariable("id") Long id_producto) {
		Productos productoActual = productoService.findProductoById(id_producto);
		productoActual.setDescripcion(productos.getDescripcion());
		productoActual.setPrecio(productos.getPrecio());
		productoActual.setCategoria(productos.getCategoria());
		productoActual.setProveedor(productos.getProveedor());
		
		return  productoService.saveProducto(productoActual);
	}
	
	@DeleteMapping ("/productos/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void deleteProducto(@PathVariable("id") Long id_producto) {
		productoService.DeleteProducto(id_producto);
	}
}
