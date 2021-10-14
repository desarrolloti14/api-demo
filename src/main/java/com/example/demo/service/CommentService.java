package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Comment;
import org.springframework.stereotype.Service;

public interface CommentService {

	public Comment getComment(Long id);
	
	public Comment createComment(Comment comment);
	
	public Comment updateComment(Comment comment);
	
	public void deleteComment(Long id);
}
