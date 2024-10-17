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
	private Long user_iduser;
	// Relación con Post (muchos comentarios pueden estar asociados a un post)
	private Long post_idpost;
	
	
	
	
	public Comment(String comentario, String date, Long user_iduser, Long post_idpost) {
		super();
		this.comentario = comentario;
		this.date = date;
		this.user_iduser = user_iduser;
		this.post_idpost = post_idpost;
	}


	public Long getUser_iduser() {
		return user_iduser;
	}


	public void setUser_iduser(Long user_iduser) {
		this.user_iduser = user_iduser;
	}




	public Long getPost_idpost() {
		return post_idpost;
	}


	public void setPost_idpost(Long post_idpost) {
		this.post_idpost = post_idpost;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", comentario=" + comentario + ", date=" + date + ", usuario=" 
				+ ", post=" + "]";
	}
	
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
