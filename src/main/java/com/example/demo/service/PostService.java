package com.example.demo.service;

import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Post;
import com.example.demo.Model.User;
import com.example.demo.dto.PostRequest;
import com.example.demo.dto.UserRequest;
import com.example.demo.repo.PostRepo;

@Service
public class PostService 
{
	  @Autowired
	  PostRepo postRepo;
	  
	  //To add a post
	  
	  public Post addUser(PostRequest postRequest)
	     {
		     
		       long id =  new Date().getTime();
		       Post post = Post.build(id,postRequest.getTitle(),postRequest.getContent(),postRequest.getUserId(), postRequest.getMedialink(),null);
		     
		       return postRepo.save(post);
	     }
	  //To Get Post by id
	  
	  public Optional<Post> getPostById(long id)
	  {
		  return postRepo.findById(id);
	  }

	public void deleteById(long id) 
	{
		 postRepo.deleteById(id);
		
	
	}

	public Post updatePostById(long id, @Valid PostRequest postRequest) 
	{
		 Post post = Post.build(id,postRequest.getTitle(),postRequest.getContent(),postRequest.getUserId(), postRequest.getMedialink(),null);
	     
	       return postRepo.save(post);
		
		
	}
 
}
