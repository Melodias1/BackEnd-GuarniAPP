package org.generation.guarniapp.controller;

import java.util.List;

import org.generation.guarniapp.model.Usuario;
import org.generation.guarniapp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.generation.guarniapp.dto.ChangePassword;

@RequestMapping(path="/api/usuarios/")
@RestController
public class UsuarioController {
	private final UsuarioService usuarioService;
	
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService=usuarioService;
	}
	
	@GetMapping
	public List<Usuario> getUsuario(){
		return usuarioService.getAllUusuario();
	}
	
	@GetMapping(path="{userId}")
	public Usuario getUsuario(@PathVariable("userId") Long Id) {
		return usuarioService.getUsuario(Id);
	}//getUsuario
	
	@PostMapping
	public Usuario addUsuarios(@RequestBody Usuario usuario) {
		return usuarioService.addUsuario(usuario);
	}//addUsuario
	
	@DeleteMapping(path="{userId}")
	public Usuario deleteUsuario(@PathVariable("userId") Long Id) {
		return usuarioService.deleteUsuario(Id);
	}//deletUsuario
	//el body retorna blanco, pero aun no encuentro porque, hay que revisar mas a fondo
	@PutMapping(path="{userId}")
	public Usuario updateUsuario(@RequestBody ChangePassword changePassword,@PathVariable("userId") Long userId) {
		return usuarioService.updateUsuario(userId,changePassword);
	}//updateUsuario
}
