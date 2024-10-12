package org.generation.guarniapp.repository;

import java.util.Optional;

import org.generation.guarniapp.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByEamil(String email);
}
