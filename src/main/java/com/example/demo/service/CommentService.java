package com.example.demo.service;

import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Comment;
import com.example.demo.Model.Post;
import com.example.demo.dto.CommentRequest;
import com.example.demo.repo.CommentRepo;

@Service
public class CommentService 
{
	@Autowired
	CommentRepo commentRepo;

	//To add a comment
	public Comment addComment(@Valid CommentRequest commentRequest) 
	{
		    long id =  new Date().getTime();
	        Comment comment = Comment.build(id,commentRequest.getComment(),commentRequest.getPostId(),commentRequest.getUserId());
	     
	       return commentRepo.save(comment);
		
	}

	public Optional<Comment> getCommentById(long id) 
	{
	      return commentRepo.findById(id);
	}

	public void delete(long id) 
	{
		commentRepo.deleteById(id);
		
	}

	public Comment update(long id, @Valid CommentRequest commentRequest) 
	{
		 Comment comment = Comment.build(id,commentRequest.getComment(),commentRequest.getPostId(),commentRequest.getUserId());
		 return commentRepo.save(comment);
	}
	

}
