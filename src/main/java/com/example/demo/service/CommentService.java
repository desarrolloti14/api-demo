package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Comment;

public interface CommentService {
	public List<Comment> getCommentPost(Long id);
	
	public Comment getComment(Long id);
	
	public Comment createComment(Comment comment);
	
	public Comment updateComment(Comment comment);
	
	public void deleteComment(Long id);
}
