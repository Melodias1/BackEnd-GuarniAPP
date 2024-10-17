package org.generation.guarniapp.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "publicaciones")
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idpost", unique=true, nullable=false)
	private Long id;
	private String postDescription;
	private String postFile;
	@Column(nullable=false)
	private String postDate;
	private String postTitle;
	
	// Relación con Comment (un post puede tener muchos comentarios)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "post_idpost", referencedColumnName = "idpost")
	List<Comment> comment = new ArrayList<Comment>();

	
	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public Post(String postDescription, String postFile, String postDate, String postTitle) {
		
		this.postDescription = postDescription;
		this.postFile = postFile;
		this.postDate = postDate;
		this.postTitle = postTitle;
	}//Constructor
	
	public Post() {}//Constructor vacio

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
