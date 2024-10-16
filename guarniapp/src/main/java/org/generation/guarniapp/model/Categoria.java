package org.generation.guarniapp.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="categoria")
public class Categoria {

//Propiedades
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="Idcategoria", unique=true, nullable=false)
private Long id;


@Column(nullable=false)
private String categoria;
@Column(nullable=false)
private String marcas;

//private static Long total = Long.valueOf(0);


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
	/*Categoria.total++;
	id = Categoria.total;*/
	
	
	//permite agregar ID a una nueva Cat.
}// CONSTRUCTO CON PARAMETROS

public Categoria() {
	/*Categoria.total++;
	id = Categoria.total;*/
	
	
}//CONSTRUCTOR VACIO

@Override
public String toString() {
	return "Categoria [id=" + id + ", categoria=" + categoria + ", marcas=" + marcas + "]";
}// TO STRING


}


