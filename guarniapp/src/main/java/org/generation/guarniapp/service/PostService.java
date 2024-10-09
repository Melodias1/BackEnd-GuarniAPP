package org.generation.guarniapp.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.generation.guarniapp.model.Post;
import org.springframework.stereotype.Service;

@Service
public class PostService {
	
	private final ArrayList<Post> lista = new ArrayList<Post> ();
	public PostService() {}//constructor
	
	public List<Post> getAllPosts() {
		return lista;
	}//getAllPosts
	
	public Post getProducto(Long postId) {
		Post p =null;
		for (Post post : lista) {
			if(post.getId()==postId) {
				p =post;
				break;
			}//if
		}//forEach
		return p;
	}//getPost
	
	public Post addPost(Post post) {
		lista.add(post);
		return post;
	}//addPost

	public Post deletePost(Long postId) {
		Post p =null;
		for (Post post : lista) {//Recorrer los elementos y encuentra uno
			if(post.getId()==postId) {
				p =lista.remove(lista.indexOf(post));
				break;
			}//if
		}//forEach
		return p;
	}//deletePost
	
	public Post updateProducto(Long id, String postDescription, String postFile, LocalDateTime postDate, String postTitle) {
		Post p =null;
		for (Post post : lista) {//Recorrer los elementos y encuentra uno
			if(post.getId()==id) {
				if (postDescription != null) post.setPostDescription(postDescription);
				if (postFile != null) post.setPostFile(postFile);
				if (postDate != null) post.setPostDate(postDate);
				if (postTitle != null) post.setPostTitle(postTitle);
				p = post;
				break;
			}//if
		}//forEach
		return p;
	}//updatePost
	
}//class PostService
