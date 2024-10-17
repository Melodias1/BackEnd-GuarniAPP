package org.generation.guarniapp.service;

import java.util.List;
import java.util.Optional;

import org.generation.guarniapp.model.Categoria;
import org.generation.guarniapp.model.Post;
import org.generation.guarniapp.model.Usuario;
import org.generation.guarniapp.repository.CategoriaRepository;
import org.generation.guarniapp.repository.PostRepository;
import org.generation.guarniapp.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
	
	public final PostRepository postRepository;
	
	public final UsuarioRepository usuarioRepository;
	
	public final CategoriaRepository categoriaRepository;
	
	@Autowired
	public PostService(PostRepository postRepository, UsuarioRepository usuarioRepository,
			CategoriaRepository categoriaRepository) {
		super();
		this.postRepository = postRepository;
		this.usuarioRepository = usuarioRepository;
		this.categoriaRepository = categoriaRepository;
	}
	
	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}//getAllPosts
	
	

	public Post getPost(Long postId) {
		return postRepository.findById(postId).orElseThrow(
				()-> new IllegalArgumentException("el producto con el id["+
				postId + "] no existe")
				);
	}//getPost
		
	public Post addPost(Post post, Long userId, Long categoriaId) {
		Optional <Post> p = postRepository.findByPostTitle(post.getPostTitle());
		if (p.isEmpty()) {//No existe el nombre
			// Buscar el usuario y la categoría
            Usuario usuario = usuarioRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("El usuario con id [" + userId + "] no existe")
            );
            Categoria categoria = categoriaRepository.findById(categoriaId).orElseThrow(
                () -> new IllegalArgumentException("La categoría con id [" + categoriaId + "] no existe")
            );
            // Asignar usuario y categoría al post
            post.setUsuario(usuario);
            post.setCategoria(categoria);

            return postRepository.save(post);
		}else{
			System.out.println("El post [" + post.getPostTitle()
					+ "] ya se encuentra registrado");
			return null;
		}//if isEmpty
	}//addPost
	
	public Post deletePost(Long postId) {
		Post p =null;
		if(postRepository.existsById(postId)) {
			p =postRepository.findById(postId).get();
			postRepository.deleteById(postId);
		}//ifexist
		return p;
	}//deletePost
	
	public Post updatePost(Long postId,Post newPost) {
		Post p =null;
		if(postRepository.existsById(postId)) {
			Post post = postRepository.findById(postId).get();
			if (newPost.getPostDescription() != null) post.setPostDescription(newPost.getPostDescription());
			if (newPost.getPostFile() != null) post.setPostFile(newPost.getPostFile());
			if (newPost.getPostDate() != null) post.setPostDate(newPost.getPostDate());
			if (newPost.getPostTitle() != null) post.setPostTitle(newPost.getPostTitle());
//			 if (newPost.getCategoria() != null) {
//	                Categoria categoria = categoriaRepository.findById(newPost.getCategoria()).orElseThrow(
//	                    () -> new IllegalArgumentException("La categoría con id [" + categoriaId + "] no existe")
//	                );
//	                post.setCategoria(categoria);
//	            }
			postRepository.save(post);
			p = post;
		}//exist
		return p;
	}//updatePost
	
}//class PostService
