package com.example.demo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Post;
import com.example.demo.dto.PostRequest;
import com.example.demo.service.PostService;

@RestController
public class PostController 
{
	@Autowired
	PostService postService;
	
	//To add a post
	
	@PostMapping("/")
	public Post addPost(@RequestBody @Valid PostRequest postRequest)
	{
		 return postService.addUser(postRequest);
	}
	
	//To find a post by id
	
	@GetMapping("/post/{id}")
	public Optional<Post> getPostById(@PathVariable("id") long id)
	{
		 return  postService.getPostById(id);
	}
	
	//To delete a post by id
	
	@DeleteMapping("/post/{id}")
	public void deletePostbyId(@PathVariable("id") long id)
	{
		postService.deleteById(id);
	}
   
	//To update a post 
	@PutMapping("/post/{id}")
	public Post updatePostById(@PathVariable("id") long id ,@RequestBody @Valid PostRequest postRequest)
	{
		 return postService.updatePostById(id,postRequest);
	}
}
