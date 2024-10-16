	package org.generation.guarniapp.model;

public class Usuario {
	//Propiedades
	private Long id;
	private String full_name;
	private String eamil;
	private String phone;
	private String password;
	
	private static Long total=Long.valueOf(0);

	public Usuario(String full_name, String eamil, String phone, String password) {
		this.full_name = full_name;
		this.eamil = eamil;
		this.phone = phone;
		this.password = password;
		Usuario.total++;
		id=Usuario.total;
	}//Constructor

	//Getters and Setters
	public Usuario() {
		Usuario.total++;
		id=Usuario.total;
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

	public String getEamil() {
		return eamil;
	}

	public void setEamil(String eamil) {
		this.eamil = eamil;
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
		return "Usuario [id=" + id + ", full_name=" + full_name + ", eamil=" + eamil + ", phone=" + phone
				+ ", password=" + password + "]";
	}
	
	
}
