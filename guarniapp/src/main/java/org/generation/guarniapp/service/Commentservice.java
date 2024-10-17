package org.generation.guarniapp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.generation.guarniapp.model.Comment;
import org.generation.guarniapp.model.Post;
import org.generation.guarniapp.model.Usuario;
import org.generation.guarniapp.repository.CommentRepository;
import org.generation.guarniapp.repository.PostRepository;
import org.generation.guarniapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class Commentservice {
	//inicializacion de la lista de objetos Comment, es fianl y static ya que no debe de cambiar y solo se debe acceder atravez de la clase
	private final CommentRepository commentRepository;
	private final UsuarioRepository usuarioRepository;
	private final PostRepository postRepository;
	
	//construccion de la lista con el constructor vacio
	@Autowired
	private Commentservice(CommentRepository commentRepository,UsuarioRepository usuarioRepository, PostRepository postRepository) {
		this.commentRepository= commentRepository;
		this.usuarioRepository=usuarioRepository;
		this.postRepository=postRepository;		
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
            commentRepository.save(comment);
            return comment;
      
    }
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
