package org.generation.guarniapp.model;

import java.time.LocalDateTime;



public class Post {
	private Long id;
	private String postDescription;
	private String postFile;
	private LocalDateTime postDate;
	private String postTitle;
	
	private static Long total = Long.valueOf(0);

	public Post(String postDescription, String postFile, LocalDateTime postDate, String postTitle) {
		super();
		this.postDescription = postDescription;
		this.postFile = postFile;
		this.postDate = postDate;
		this.postTitle = postTitle;
		Post.total ++;
		id = Post.total;
	}//Constructor
	
	public Post() {
		Post.total ++;
		id = Post.total;
	}//Constructor vacio

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

	public LocalDateTime getPostDate() {
		return postDate;
	}//getPostDate

	public void setPostDate(LocalDateTime postDate) {
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
