package org.generation.guarniapp.dto;

public class ChangePassword {
	//Propiedades
	private String password;
	private String newPassword;
	
	//Getters and Setters
	
	public String getPassword() {
		return password;
	}
	//se le agrega se cambia por this.password
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public ChangePassword(String password, String newPassword) {
		this.password= password;
		this.newPassword = newPassword;
	}//constructor

	public ChangePassword() {
		
	}//constructor vacio
	
	
	
	
	
}
