package org.generation.guarniapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class Usuario {
	//Propiedades
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="iduser", unique=true, nullable=false)
	private Long id;
	@Column(nullable=false)
	private String full_name;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String phone;
	@Column(nullable=false)
	private String password;
	
//	private static Long total=Long.valueOf(0);

	public Usuario(String full_name, String eamil, String phone, String password) {
		this.full_name = full_name;
		this.email = eamil;
		this.phone = phone;
		this.password = password;
//		Usuario.total++;
//		id=Usuario.total;
	}//Constructor

	//Getters and Setters
	public Usuario() {
//		Usuario.total++;
//		id=Usuario.total;
	}//Constructor Vacio

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String eamil) {
		this.email = eamil;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	//toString
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", full_name=" + full_name + ", eamil=" + email + ", phone=" + phone
				+ ", password=" + password + "]";
	}
	
	
}
