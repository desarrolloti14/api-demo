package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name = "posts")
@Data
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "The title is required")
	@Size(max = 50, min = 1, message = "Title length is 1-50")
	@Column(length = 50, nullable = false)
	private String title;
	
	@NotEmpty(message = "The body is required")
	@Size(max = 150, min = 1, message = "Body length is 1-50")
	@Column(length = 150, nullable = false)
	private String body;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date update_at;
	
	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = true	)
	@JsonManagedReference
	private List<Comment> comments = new ArrayList<Comment>();

}	
