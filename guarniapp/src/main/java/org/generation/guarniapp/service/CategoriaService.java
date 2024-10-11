package org.generation.guarniapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.generation.guarniapp.controller.CategoriaController;
import org.generation.guarniapp.model.Categoria;
import org.generation.guarniapp.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//se agrega anotacion service
@Service
public class CategoriaService {
//private static final ArrayList<Categoria> lista = new ArrayList<Categoria>();
public final CategoriaRepository categoriaRepository;

@Autowired	
public CategoriaService(CategoriaRepository categoriaRepository) {
	this.categoriaRepository= categoriaRepository;
/*	lista.add(new Categoria("Pollo frito", "Bachoco"));
	lista.add(new Categoria("Italiana", "Prego"));
	lista.add(new Categoria("Mexicana", "La Costeña"));*/
}
	public List<Categoria> getAllCategorias() {		
		return categoriaRepository.findAll();
	}
	//se agrega if para que el id cooincida con el id recibido y retornar solo ese id
	public Categoria getCategoria(Long catId) {
		return categoriaRepository.findById(catId).orElseThrow(
				()-> new IllegalArgumentException("El producto con el id ["
						+"] no existe"));
	}
	public Categoria addCategoria(Categoria categoria) {
		Optional<Categoria> cat= categoriaRepository.findByCategoria(categoria.getCategoria());
		if (cat.isEmpty()) {
			return categoriaRepository.save(categoria);
		}else {
			System.out.println("La categoria ["+categoria.getCategoria()+"] ya se encuentra registrado.");
			return null;
		}
	}
	public Categoria deleteCategoria(Long catId) {
		Categoria cat=null;
		if (categoriaRepository.existsById(catId)) {
			cat=categoriaRepository.findById(catId).get();
			categoriaRepository.deleteById(catId);
		}
		return cat;
	}
	public Categoria updateCategoria(Long catId, String categoria, String marcas) {
		Categoria cat=null;
		if (categoriaRepository.existsById(catId)) {
			Categoria categoriaa= categoriaRepository.findById(catId).get();
			if(categoria!=null)categoriaa.setCategoria(categoria);
			if(marcas!=null)categoriaa.setMarcas(marcas);
			categoriaRepository.save(categoriaa);
			cat=categoriaa;
		}
		return cat;
	} 

}
