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
	@ManyToOne
	@JoinColumn(name = "user_iduser")  // Hibernate creará la columna en la tabla Post
	private Usuario usuario;
	@ManyToOne
	@JoinColumn(name = "categoria_idcategoria")  // Hibernate creará la columna en la tabla Post
	private Categoria categoria;
	// Relación con Comment (un post puede tener muchos comentarios)
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	private List<Comment> comment = new ArrayList<>();

	public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public Categoria getCategoria() {
			return categoria;
		}

		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}

		public List<Comment> getComment() {
			return comment;
		}

		public void setComment(List<Comment> comment) {
			this.comment = comment;
		}

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
