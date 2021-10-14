package com.example.demo.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = Comment.class)
@Entity
@Table(name = "comments")
@Data
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@NotEmpty(message = "The comment is required")
	@Size(max = 150, min = 1, message =  "The comment is 1 - 150")
	@Column(length = 150, nullable = false)
	public String comment;
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date created_at;
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date updated_at;
	
	//@JsonIgnore
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch= FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name="post_id", referencedColumnName="id", nullable = false, updatable = false)
	private Post post;
	
}
