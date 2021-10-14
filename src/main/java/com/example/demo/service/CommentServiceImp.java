package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Comment;
import com.example.demo.repository.CommentRepository;

@Service
public class CommentServiceImp implements CommentService {
	@Autowired
	private CommentRepository commentRepository;

	@Override
	public List<Comment> getCommentIdPost(Long id) {
		return commentRepository.findCommentByPostId(id);
	}

	@Override
	public Comment getComment(Long id) {
		return commentRepository.findById(id).orElse(null);
	}

	@Override
	public Comment createComment(Comment comment) {
		comment.setCreated_at(new Date());
		return commentRepository.save(comment);

	}

	@Override
	public Comment updateComment(Comment comment) {
		Comment commentDB = getComment(comment.getId());
		if (commentDB == null) {
			return null;
		}
		commentDB.setComment(comment.getComment());
		commentDB.setUpdated_at(new Date());
		return commentRepository.save(commentDB);

	}

	@Override
	public void deleteComment(Long id) {
		commentRepository.deleteById(id);
	}
}
