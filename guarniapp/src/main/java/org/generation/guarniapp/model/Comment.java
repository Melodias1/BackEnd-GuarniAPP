package org.generation.guarniapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="comments")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcomments",nullable = true, unique = true)
	private Long id;
	@Column(nullable = true)
	private String comentario;
	private String date;
	// Relación con Usuario (muchos comentarios pueden estar asociados a un usuario)
    @ManyToOne
    @JoinColumn(name="user_iduser", nullable = false)
    private Usuario usuario;
 // Relación con Post (muchos comentarios pueden estar asociados a un post)
    @ManyToOne
    @JoinColumn(name="post_idpost", nullable = false)
    private Post post;
	
	
	
	
	@Override
	public String toString() {
		return "Comment [id=" + id + ", comentario=" + comentario + ", date=" + date + ", usuario=" + usuario
				+ ", post=" + post + "]";
	}




	public Usuario getUsuario() {
		return usuario;
	}




	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}




	public Post getPost() {
		return post;
	}




	public void setPost(Post post) {
		this.post = post;
	}




	public Comment(String comentario, String date) {
		
		this.comentario = comentario;
		
		this.date = date;
		
	}//constructor using fields
	
	
	
	
	public Comment() {
	
	}//empty contructor

	


	public Long getId() {
		return id;
	}//getId

	public void setId(Long id) {
		this.id = id;
	}//setIdd

	public String getComentario() {
		return comentario;
	}//getcomentario
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}//setComentarop
	
	public String getDate() {
		return date;
	}//getDate
	public void setDate(String date) {
		this.date = date;
	}//setDate





	
	
	

}//class
