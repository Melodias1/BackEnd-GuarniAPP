package org.generation.guarniapp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.generation.guarniapp.model.Comment;
import org.generation.guarniapp.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class Commentservice {
	//inicializacion de la lista de objetos Comment, es fianl y static ya que no debe de cambiar y solo se debe acceder atravez de la clase
	CommentRepository commentRepository;
	
	
	//construccion de la lista con el constructor vacio
	@Autowired
	private Commentservice(CommentRepository commentRepository) {
		this.commentRepository= commentRepository;
	}
		
//metodo para retornal todos los comentarios
	public List<Comment> getAllComments() {
		
		return commentRepository.findAll();
	}// getAllcomments

	//metodo para obtener solo 1 commentario por medio de su id
	public Comment getComment(Long commentId) {
		
		return commentRepository.findById(commentId).orElseThrow(
				()-> new IllegalArgumentException("el id de comenttario "
						+commentId +"[] no existe")
				);
	}//get Comment

	public Comment addComment(Comment comment) {
		Optional<Comment> com= commentRepository.findByComentario(comment.getComentario());
			if(com.isEmpty()) {
				commentRepository.save(comment);
				return comment;
			}else {
				System.out.println("el commentario ["
						+comment.getComentario() +"] ya fue realizado,no se permite hacer spam");
			}
		
		return null;
	}//add

	public Comment deleteComment(Long commentId) {
		Comment com=null;
		if(commentRepository.existsById(commentId)) {
			com= commentRepository.findById(commentId).get();
			commentRepository.delete(com);
			
		}//if exist
		return com;
	}//deletecomment

	public Comment editComment(Long id, String comentario) {
		Comment com=null;
			if(commentRepository.existsById(id)) {
				if(comentario!=null) {
					com = commentRepository.findById(id).get();
				com.setComentario(comentario);
				commentRepository.save(com);
				
				}//if
			
			
		}//if
		
		return com;
	}//edit commentario
	
	
	
	
	
}
