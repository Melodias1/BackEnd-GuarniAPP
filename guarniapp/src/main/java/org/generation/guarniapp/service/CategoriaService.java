package org.generation.guarniapp.service;

import java.util.ArrayList;

import org.generation.guarniapp.controller.CategoriaController;
import org.generation.guarniapp.model.Categoria;

public class CategoriaService {
private static final ArrayList<Categoria> lista = new ArrayList<Categoria>();

public CategoriaService() {
	lista.add(new Categoria("Pollo frito", "Bachoco"));
	lista.add(new Categoria("Italiana", "Prego"));
	lista.add(new Categoria("Mexicana", "La Costeña"));
}
	public ArrayList<Categoria> getAllCategorias() {		
		return lista;
	}
	public Categoria getCategoria(Long catId) {
		Categoria cat=null;
		for (Categoria categoria : lista) {
			cat = categoria;
			break;
		}
		return cat;
	}
	public Categoria addCategoria(Categoria categoria) {
		lista.add(categoria);
		return categoria;
	}
	public Categoria deleteCategoria(Long catId) {
		Categoria cat=null;
		for (Categoria categoria : lista) {
			if (categoria.getId()==catId) {
				cat=lista.remove(lista.indexOf(categoria));
				break;
			}
		}
		return cat;
	}
	public Categoria updateCategoria(Long catId, String categoria, String marcas) {
		Categoria cat=null;
		for (Categoria categoriaa : lista) {
			if (categoriaa.getId()==catId) {
				if(categoria!=null)categoriaa.setCategoria(categoria);
				if(marcas!=null)categoriaa.setMarcas(marcas);
				cat = categoriaa;
			}
		}
		return cat;
	} 

}
