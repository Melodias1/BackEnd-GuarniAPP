package org.generation.guarniapp.service;

import java.util.ArrayList;

import org.generation.guarniapp.model.Usuario;
import org.springframework.stereotype.Service;

import org.generation.guarniapp.dto.ChangePassword;

@Service
public class UsuarioService {

	private static final ArrayList<Usuario> lista = new ArrayList<Usuario>();
	
	public UsuarioService() {
		lista.add(new Usuario("Manuel Estrada","mauel@gmail.com", "7223567890", "contrasena1"));
		lista.add(new Usuario("Jose Jose","jose@gmail.com", "7223234567", "contrasena12"));
	}//constructor
	
	public ArrayList<Usuario> getAllUusuario() {
		return lista;
	}//ArrayList
	
	public Usuario getUsuario(Long Id) {
		Usuario usr=null;
		for (Usuario usuario : lista) {
			if (usuario.getId()==Id) {
				usr=usuario;
				break;
			}
		}
		
		return usr;
	}//getUsuario
	//se agrega el user= usuario ya que retornaba null todo el tiempo
	public Usuario addUsuario(Usuario usuario) {
		Usuario user = null;
		boolean flag = false;
		for (Usuario u : lista) {
			if (u.getEamil().equals(usuario.getEamil())) {//si el correo ya existe
				flag = true;
				break;
			}
		}//for
		if (!flag) {
			lista.add(usuario);
			user=usuario;
		}
		return user;
	}//addUsuario
	
	public Usuario deleteUsuario(Long Id) {
		Usuario usr=null;
		for (Usuario usuario : lista) {
			if (usuario.getId()==Id) {
				usr= lista.remove(lista.indexOf(usuario));
				break;
			}
		}
		
		return usr;
	}//deleteUsuario
	
	public Usuario updateUsuario(Long userId, ChangePassword changePassword) {
		Usuario aux= null;
		for (Usuario usuario : lista) {
			if (usuario.getId()==userId) {
				if (usuario.getPassword().equals(changePassword.getPassword())) {
					usuario.setPassword(changePassword.getNewPassword());
					aux=usuario;
					
				}
				break;
			}
		}
		return aux;
	}//updateUsuario
	

}
