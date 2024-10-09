package org.generation.guarniapp.dto;

public class ChangePassword {
	//Propiedades
	private String Password;
	private String newPassword;
	
	//Getters and Setters
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public ChangePassword(String password, String newPassword) {
		this.Password= password;
		this.newPassword = newPassword;
	}//constructor

	public ChangePassword() {
		
	}//constructor vacio
	
	
	
	
	
}
