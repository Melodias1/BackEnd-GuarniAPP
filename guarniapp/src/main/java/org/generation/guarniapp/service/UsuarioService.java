package org.generation.guarniapp.service;

import java.util.List;
import java.util.Optional;

import org.generation.guarniapp.model.Usuario;
import org.generation.guarniapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.generation.guarniapp.dto.ChangePassword;

@Service
public class UsuarioService {

//	private static final ArrayList<Usuario> lista = new ArrayList<Usuario>();
	
	@Autowired
	private PasswordEncoder encoder;
	
	public final UsuarioRepository usuarioRepository;
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
//		lista.add(new Usuario("Manuel Estrada","mauel@gmail.com", "7223567890", "contrasena1"));
//		lista.add(new Usuario("Jose Jose","jose@gmail.com", "7223234567", "contrasena12"));
		this.usuarioRepository= usuarioRepository;
	}//constructor
	
	public List<Usuario> getAllUusuario() {
		return usuarioRepository.findAll();
	}//getUsuario
	
	public Usuario getUsuario(Long Id) {
		return usuarioRepository.findById(Id).orElseThrow(
				()-> new IllegalArgumentException("El usuario con el id ["+
						"] no existe")
				);
	}//getUsuario
	public Usuario addUsuario(Usuario usuario) {
		Optional<Usuario> user = usuarioRepository.findByEmail(usuario.getEmail());
		if (user.isEmpty()) {//No existe el email
			usuario.setPassword(encoder.encode(usuario.getPassword()));
			return usuarioRepository.save(usuario);
		}else {
			System.out.println("El email ["+usuario.getEmail()+"] ya se encuentra registrado");
			return null;
		}
	}//addUsuario
	
	public Usuario deleteUsuario(Long Id) {
		Usuario usr=null;
		if (usuarioRepository.existsById(Id)) {
			usr= usuarioRepository.findById(Id).get();
			usuarioRepository.deleteById(Id);
		}
		
		return usr;
	}//deleteUsuario
	
	public Usuario updateUsuario(Long userId, ChangePassword changePassword) {
		Usuario aux= null;
			if (usuarioRepository.existsById(userId)) {
				Usuario usuario = usuarioRepository.findById(userId).get();
				if (encoder.matches(changePassword.getPassword(), usuario.getPassword())) {
					usuario.setPassword(encoder.encode(changePassword.getNewPassword()));
					usuarioRepository.save(usuario);
					aux=usuario;
					
				}
			}
		
		return aux;
	}//updateUsuario
	
	public Usuario validateUser(Usuario usuario) {
		Optional<Usuario> user = usuarioRepository.findByEmail(usuario.getEmail());
		if (user.isEmpty()) {
			return null;
		}
		if (encoder.matches(usuario.getPassword(), user.get().getPassword())) {
			return user.get();
		}
		return null;
	}
	

}
