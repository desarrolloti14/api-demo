package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = Comment.class)
@Entity
@Table(name = "posts")
@Data
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "The title is required")
	@Size(max = 50, message = "Title is very long")
	@Column(length = 50, nullable = false)
	private String title;
	
	@NotNull(message = "The body is required")
	@Size(max = 50, message = "Body is very long")
	@Column(length = 150, nullable = false)
	private String body;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date update_at;

	
	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
	private List<Comment> comments = new ArrayList<Comment>();
	//private Set<Comment> comments;
	
}	
