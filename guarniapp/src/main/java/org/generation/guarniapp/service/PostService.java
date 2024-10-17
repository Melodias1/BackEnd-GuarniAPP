package org.generation.guarniapp.service;

import java.util.List;
import java.util.Optional;

import org.generation.guarniapp.model.Post;
import org.generation.guarniapp.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PostService {
	
	public final PostRepository postRepository;
	
	@Autowired
	public PostService(PostRepository postRepository) {
		super();
		this.postRepository = postRepository;
	}//constructor
	
	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}//getAllPosts
	
	public Post getPost(Long postId) {
		return postRepository.findById(postId).orElseThrow(
				()-> new IllegalArgumentException("El post con el id["+
				postId + "] no existe")
				);
	}//getPost
		
	public Post addPost(Post post) {
		Optional <Post> p = postRepository.findByPostTitle(post.getPostTitle());
		if (p.isEmpty()) {//No existe el nombre
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
	
	public Post updatePost(Long postId, String postDescription, String postFile, String postDate, String postTitle) {
		Post p =null;
		if(postRepository.existsById(postId)) {
			Post post = postRepository.findById(postId).get();
			if (postDescription != null) post.setPostDescription(postDescription);
			if (postFile != null) post.setPostFile(postFile);
			if (postDate != null) post.setPostDate(postDate);
			if (postTitle != null) post.setPostTitle(postTitle);
			postRepository.save(post);
			p = post;
		}//exist
		return p;
	}//updatePost

}//class PostService
