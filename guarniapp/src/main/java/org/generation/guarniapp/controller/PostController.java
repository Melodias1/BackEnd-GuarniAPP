package org.generation.guarniapp.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.generation.guarniapp.model.Post;
import org.generation.guarniapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path="/api/post/")// http://localhost:8080/api/post/
public class PostController {
	private final PostService postService;

	@Autowired
	public PostController(PostService postService) {
		super();
		this.postService = postService;
	}//constructor
	
	@GetMapping
	public List<Post> getPosts() {
		return postService.getAllPosts();
	}//getPosts
	
	@GetMapping(path = "{postId}") //https://localhost:8080/api/post/1
	public Post getPost(@PathVariable("postId")Long postId) {
		return postService.getProducto(postId);
	}//getPost
	//creo que el tipo de dato de fecha tiene que ser en texto, o que se genere de forma automatica, de otra manera solo corre el metodo si el valor de date es null ya que no encontre forma de mandar el tipo de dato localtime desde el json
	@PostMapping //https://localhost:8080/api/post/
	public Post addPost(@RequestBody Post post) {
		return postService.addPost(post);
	}//addPost
	
	@DeleteMapping(path = "{postId}") //https://localhost:8080/api/post/1
	public Post deletePost(@PathVariable("prodId")Long postId) {
		return postService.deletePost(postId);
	}//deletePost
	//no encontre manera de que funcionara, creo que es por lo mismo que en metodo post, por el dato local time
	@PutMapping (path = "{postId}") //https://localhost:8080/api/post/1
	public Post updateProducto(@PathVariable("postId")Long postId,
			@RequestParam(required=false)String postDescription,
			@RequestParam(required=false)String postFile,
			@RequestParam(required=false)LocalDateTime postDate,
			@RequestParam(required=false)String postTitle
			) {
		return postService.updateProducto(postId, postDescription, postFile, postDate, postTitle);
	}//updatePost
	
	
}//class ProductoController
