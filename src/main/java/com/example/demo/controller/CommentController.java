package com.example.demo.controller;

import javax.validation.Valid;

import com.example.demo.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Comment;
import com.example.demo.service.CommentService;

import java.util.List;

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
	public ResponseEntity<?> updateComment(@Valid @PathVariable(value = "id") Long id, @RequestBody Comment comment) {
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
