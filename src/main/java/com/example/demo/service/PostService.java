package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Post;

public interface PostService {
	public List<Post> getAllPost();
	
	public Post getPost(Long id);
	
	public Post createPost(Post post);
	
	public Post updatePost(Post post);
	
	public void deletePost(Long id);
}
