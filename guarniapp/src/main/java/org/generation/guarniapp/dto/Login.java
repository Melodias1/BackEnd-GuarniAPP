package org.generation.guarniapp.dto;

import org.generation.guarniapp.model.Usuario;

public class Login {
	private Token token;
	private Usuario usuario;

	public Login(Token token, Usuario usuario) {
		this.token = token;
		this.usuario = usuario;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
