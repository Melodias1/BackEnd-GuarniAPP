package org.generation.guarniapp.repository;

import java.util.Optional;

import org.generation.guarniapp.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
	
	Optional<Comment> findByComentario(String comentario);

}
