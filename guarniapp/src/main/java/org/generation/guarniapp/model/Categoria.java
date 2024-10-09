package org.generation.guarniapp.model;

public class Categoria {

//Propiedades
private Long id;


private String categoria;

private String marcas;

private static Long total = Long.valueOf(0);


public Long getId() {
	return id;
}//GET ID

public void setId(Long id) {
	this.id = id;
}//SET ID

public String getCategoria() {
	return categoria;
}//GET CATEGORIA

public void setCategoria(String categoria) {
	this.categoria = categoria;
}//SET CATEGORIA

public String getMarcas() {
	return marcas;
}//GET MARCAS

public void setMarcas(String marcas) {
	this.marcas = marcas;
}//SET MARCAS

public Categoria(String categoria, String marcas) {
	this.categoria = categoria;
	this.marcas = marcas;
	Categoria.total++;
	id = Categoria.total;
	//permite agregar ID a una nueva Cat.
}// CONSTRUCTO CON PARAMETROS

public Categoria() {
	Categoria.total++;
	id = Categoria.total;
}//CONSTRUCTOR VACIO

@Override
public String toString() {
	return "Categoria [id=" + id + ", categoria=" + categoria + ", marcas=" + marcas + "]";
}// TO STRING


}


