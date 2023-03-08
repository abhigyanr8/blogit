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

import com.example.demo.Model.Comment;
import com.example.demo.dto.CommentRequest;
import com.example.demo.service.CommentService;

@RestController
public class CommentController 
{
	@Autowired
	CommentService commentService;
	
	//To add a comment
	
	@PostMapping("/comment")
	public Comment addComment(@RequestBody @Valid CommentRequest commentRequest)
	{
		return commentService.addComment(commentRequest);
	}
	
	//To get a comment by id
	
	@GetMapping("/comment/{id}")
	public Optional<Comment> getCommentById(@PathVariable("id") long id)
	{
		return commentService.getCommentById(id);
	}
	
	@DeleteMapping("/comment/{id}")
	public void delete(@PathVariable("id") long id)
	{
		 commentService.delete(id);
	}
	
	@PutMapping("/comment/{id}")
	public Comment update(@PathVariable("id") long id,@RequestBody @Valid CommentRequest commentRequest)
	{
		return commentService.update(id,commentRequest);
	}

}
