package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Post;
import com.example.demo.repository.PostRepository;

@Service
public class PostServiceImp implements PostService {
	@Autowired
	private PostRepository postRepository;

	@Override
	public List<Post> getAllPost() {
		return postRepository.findAll();
	}

	@Override
	public Post getPost(Long id) {
		return postRepository.findById(id).orElse(null);
	}

	@Override
	public Post createPost(Post post) {
		return postRepository.save(post);
	}

	@Override
	public Post updatePost(Post post) {
		Post postDB = getPost(post.getId());
		if (postDB == null) {
			return null;
		}
		postDB.setTitle(post.getTitle());
		postDB.setBody(post.getBody());
		return postRepository.save(postDB);
	}

	@Override
	public void deletePost(Long id) {
		postRepository.deleteById(id);
	}


}
