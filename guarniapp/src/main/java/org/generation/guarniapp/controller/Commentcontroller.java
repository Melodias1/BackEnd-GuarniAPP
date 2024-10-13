package org.generation.guarniapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.generation.guarniapp.model.Comment;
import org.generation.guarniapp.service.Commentservice;
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
@RequestMapping(path="/api/comment/")
public class Commentcontroller {
	//instancia de servicio
	private final Commentservice commentService;
		@Autowired
		public Commentcontroller(Commentservice commentService) {
			this.commentService=commentService;
		}//inicializacion de servicio
		@GetMapping
		public List<Comment> getAllComments() {
			
			return commentService.getAllComments();
			
		}//getallcomment
		
		@GetMapping(path="{commentId}")
		public Comment getComment(@PathVariable("commentId")Long commentId) {
			return commentService.getComment(commentId);
		}//getcomment
		@PostMapping
		public Comment addComment(@RequestBody Comment comment) {
			return commentService.addComment(comment);
		}//add
		@DeleteMapping(path="{commentId}")
		public Comment deleteComment(@PathVariable("commentId")Long commentId) {
			return commentService.deleteComment(commentId);
		}//delete
		@PutMapping(path="{commentId}")
		public Comment editCommen(@PathVariable("commentId") Long id,@RequestParam(required=false) String comentario) {
			return commentService.editComment(id,comentario);
		}
}//clase
