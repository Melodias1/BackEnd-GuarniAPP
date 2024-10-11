package org.generation.guarniapp.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "publicaciones")
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	private String postDescription;
	private String postFile;
	@Column(nullable=false)
	private String postDate;
	private String postTitle;
	
	private static Long total = Long.valueOf(0);

	public Post(String postDescription, String postFile, String postDate, String postTitle) {
		super();
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
