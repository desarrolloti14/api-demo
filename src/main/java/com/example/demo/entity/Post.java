package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "posts")
@Data
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Title is required")
	@Size(max = 50, message = "Title is very long")
	@Column(length = 50, nullable = false)
	private String title;
	
	@NotNull(message = "Body is required")
	@Size(max = 50, message = "Body is very long")
	@Column(length = 150, nullable = false)
	private String body;
}
