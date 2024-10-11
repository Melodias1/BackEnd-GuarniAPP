package org.generation.guarniapp.repository;

import java.util.Optional;

import org.generation.guarniapp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository <Post, Long>{
	Optional<Post> findByTitle(String title);
	
}// interface PostRepository
