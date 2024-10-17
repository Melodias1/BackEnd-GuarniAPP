package org.generation.guarniapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "publicaciones")
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idpost", unique=true, nullable=false)
	private Long id;
	private String postDescription;
	private String postFile;
	private String postDate;
	@Column(nullable=false)
	private String postTitle;
	private Long user_iduser;
	private Long categoria_idcategoria;
	// Relación con Comment (un post puede tener muchos comentarios)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "post_idpost", referencedColumnName = "idpost")
	List<Comment> comment = new ArrayList<Comment>();

	public Post(String postDescription, String postFile, String postDate, String postTitle) {
		this.postDescription = postDescription;
		this.postFile = postFile;
		this.postDate = postDate;
		this.postTitle = postTitle;
	}//Constructor
	
	public Post() {}//Constructor vacio

	public Long getUser_iduser() {
		return user_iduser;
	}

	public void setUser_iduser(Long user_iduser) {
		this.user_iduser = user_iduser;
	}

	public Long getCategoria_idcategoria() {
		return categoria_idcategoria;
	}

	public void setCategoria_idcategoria(Long categoria_idcategoria) {
		this.categoria_idcategoria = categoria_idcategoria;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public Long getId() {
		return id;
	}//getId

	public void setId(Long id) {
		this.id = id;
	}//setId

	public String getPostDescription() {
		return postDescription;
	}//getPostDescription

	public void setPostDescription(String postDescription) {
		this.postDescription = postDescription;
	}//setPostDescription

	public String getPostFile() {
		return postFile;
	}//getPostFile

	public void setPostFile(String postFile) {
		this.postFile = postFile;
	}//setPostFile

	public String getPostDate() {
		return postDate;
	}//getPostDate

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}//setPostDate

	public String getPostTitle() {
		return postTitle;
	}//getPostTitle

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}//setPostTitle

	@Override
	public String toString() {
		return "Post [id=" + id + ", postDescription=" + postDescription + ", postFile=" + postFile + ", postDate="
				+ postDate + ", postTitle=" + postTitle + "]";
	}//toString
	
	
}//classPost
