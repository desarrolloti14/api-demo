package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Post;
import com.example.demo.service.PostService;

@RestController
@RequestMapping(value = "api/demo/posts")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class PostController {
	@Autowired
	private PostService postService;
	
	@GetMapping
	public ResponseEntity<List<?>> getAllPost() {
		List<Post> posts = postService.getAllPost();
		if (posts == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(posts);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> GetPost(@PathVariable(value = "id") Long id) {
		Post post = postService.getPost(id);
		if (post == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(post);
	}
	
	@PostMapping
	public ResponseEntity<?> createPost(@RequestBody @Valid Post post) {
		Post postCreated = postService.createPost(post);
		return ResponseEntity.status(HttpStatus.CREATED).body(postCreated);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateEntity(@Valid @PathVariable(value = "id") Long id, @RequestBody Post post) {
		post.setId(id);
		Post postUpdated = postService.updatePost(post);
		if (postUpdated == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(postUpdated);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletePost(@PathVariable(value = "id") Long id) {
		Post postDeleted = postService.getPost(id);
		if (postDeleted == null) {
			return ResponseEntity.notFound().build();
		}
		postService.deletePost(id);
		return ResponseEntity.ok().build();
	}

}
