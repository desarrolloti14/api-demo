package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Comment;
import com.example.demo.service.CommentService;

@RestController
@RequestMapping(value = "api/demo/comments")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@PostMapping
	public ResponseEntity<?> createComment(@Valid @RequestBody Comment comment) {
		Comment commentDB = commentService.createComment(comment);
		return ResponseEntity.status(HttpStatus.CREATED).body(commentDB);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateComment(@Valid @PathVariable(name = "id") Long id, @RequestBody Comment comment) {
		comment.setId(id);
		Comment commentUpdated = commentService.updateComment(comment);
		if (commentUpdated == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(commentUpdated);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteComment(@PathVariable(value = "id") Long id) {
		Comment commentDeleted = commentService.getComment(id);
		if (commentDeleted == null) {
			return ResponseEntity.notFound().build();
		}
		commentService.deleteComment(id);
		return ResponseEntity.ok().build();
	}
}
