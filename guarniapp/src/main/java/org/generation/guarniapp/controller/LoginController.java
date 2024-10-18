package org.generation.guarniapp.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;

import org.generation.guarniapp.config.JwtFilter;
import org.generation.guarniapp.dto.Login;
import org.generation.guarniapp.dto.Token;
import org.generation.guarniapp.model.Usuario;
import org.generation.guarniapp.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(path="/api/login/")
public class LoginController {
	private final UsuarioService usuarioService;

	public LoginController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@PostMapping
	public ResponseEntity<Login> loginUser(@RequestBody Usuario usuario) throws ServletException {
	    Usuario user = usuarioService.validateUser(usuario);
	    if (user != null) {
	        System.out.println("Usuario válido: " + user.getEmail());

	        Token token = new Token(generateToken(user.getEmail()));
	        //Retorna null en los parametros
	        user.setPassword(null);
	        user.setPhone(null);
	        return ResponseEntity.ok(new Login(token, user));  
	    }
	    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
	}

	
	private String generateToken(String email) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, 12);
		return Jwts.builder().setSubject(email).claim("role", "user")
				.setIssuedAt(new Date()).setExpiration(calendar.getTime())
				.signWith(SignatureAlgorithm.HS256, JwtFilter.secret).compact();
		
	}
	

}
