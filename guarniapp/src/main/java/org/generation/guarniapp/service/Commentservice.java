package org.generation.guarniapp.service;

import java.util.ArrayList;
import java.util.Iterator;

import org.generation.guarniapp.model.Comment;
import org.springframework.stereotype.Service;
@Service
public class Commentservice {
	//inicializacion de la lista de objetos Comment, es fianl y static ya que no debe de cambiar y solo se debe acceder atravez de la clase
	private final static ArrayList<Comment> commentList= new ArrayList<Comment>();

	//construccion de la lista con el constructor vacio
	private Commentservice() {
		commentList.add(new Comment("Que deliciosa receta",1l,1l,"2024-10-09"));
		commentList.add(new Comment("Muy practica",2l,2l,"2024-10-10"));
		commentList.add(new Comment("Que original",3l,3l,"2024-10-11"));
		commentList.add(new Comment("Cuantas personas comen?",3l,3l,"2024-10-11"));
		commentList.add(new Comment("Donde puedo comprar los ingredientes?",4l,4l,"2024-10-12"));
	}

//metodo para retornal todos los comentarios
	public ArrayList<Comment> getAllComments() {
		
		return commentList;
	}// getAllcomments

	//metodo para obtener solo 1 commentario por medio de su id
	public Comment getComment(Long commentId) {
		Comment com=null;
		for (Comment comment : commentList) {
			if (comment.getId()==commentId) {
				com=comment;
				
			}//if
		}//for
		return com;
	}//get Comment

	public Comment addComment(Comment comment) {
		commentList.add(comment);
		
		return comment;
	}//add

	public Comment deleteComment(Long commentId) {
		Comment com = null;
		for (Comment comment : commentList) {
			if(comment.getId()==commentId ) {
				com= commentList.remove(commentList.indexOf(comment));
				break;
			}//if
			
		}//for
		return com;
	}//deletecomment

	public Comment editComment(Long id, String comentario) {
		Comment com=null;
		for (Comment comment : commentList) {
			if(comment.getId()==id) {
				if(comentario!=null) {
				comment.setComentario(comentario);
				com=comment;
				break;
				}//if
			}//if
			
		}//for
		
		return com;
	}//edit commentario
	
	
	
	
	
}
