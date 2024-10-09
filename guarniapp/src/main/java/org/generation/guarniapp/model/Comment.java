package org.generation.guarniapp.model;

public class Comment {
	//PK
	private Long id;
	private String comentario;
	//FK
	private Long user_iduser;
	//FK
	private Long post_idpost;
	private String date;
	private static Long total = Long.valueOf(0);
	
	
	
	
	
	public Comment(String comentario, Long user_iduser, Long post_idpost, String date) {
		
		this.comentario = comentario;
		this.user_iduser = user_iduser;
		this.post_idpost = post_idpost;
		this.date = date;
		Comment.total++;
		this.id=total;
		
	}//constructor using fields
	
	
	
	
	public Comment() {
		Comment.total++;
		this.id=total;
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
	public Long getUser_iduser() {
		return user_iduser;
	}//getUserId
	public void setUser_iduser(Long user_iduser) {
		this.user_iduser = user_iduser;
	}//setUserId
	public Long getPost_idpost() {
		return post_idpost;
	}//getIdPost
	public void setPost_idpost(Long post_idpost) {
		this.post_idpost = post_idpost;
	}//setIdPost
	public String getDate() {
		return date;
	}//getDate
	public void setDate(String date) {
		this.date = date;
	}//setDate




	@Override
	public String toString() {
		return "Comment [id=" + id + ", comentario=" + comentario + ", user_iduser=" + user_iduser + ", post_idpost="
				+ post_idpost + ", date=" + date + "]";
	}//Tostring
	
	
	

}//class
