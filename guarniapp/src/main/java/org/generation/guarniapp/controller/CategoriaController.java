package org.generation.guarniapp.controller;


import java.util.ArrayList;

import org.generation.guarniapp.model.Categoria;
import org.generation.guarniapp.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RequestMapping(path="/api/categoria/")
@RestControllerAdvice
public class CategoriaController {
private final CategoriaService categoriaService;

@Autowired
public CategoriaController(CategoriaService categoriaService) {
	this.categoriaService = categoriaService;
	
}
@GetMapping
public ArrayList<Categoria> getCategoria(){
	return categoriaService.getAllCategorias();
}

@GetMapping(path = "catId")
public Categoria getCategoria(@PathVariable("catId") Long catId ) {
	return categoriaService.getCategoria(catId);
}
@PostMapping
public Categoria addCategoria(@RequestBody Categoria categoria) {
	return categoriaService.addCategoria(categoria);
}
@DeleteMapping(path = "catId")
public Categoria deleteCategoria(@PathVariable("catId")Long catId) {
	return categoriaService.deleteCategoria(catId);
}
@PutMapping(path = "catId")
public Categoria updateCategoria(@PathVariable("catId")Long catId,
								@RequestParam(required = false) String	categoria,
								@RequestParam(required = false) String	marcas) {
	return categoriaService.updateCategoria(catId, categoria, marcas);
}
}
