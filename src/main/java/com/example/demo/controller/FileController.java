package com.example.demo.controller;

import java.io.IOException;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.Model.Post;
import com.example.demo.Model.FileData;
import com.example.demo.repo.PostRepo;
import com.example.demo.service.PostService;
import com.example.demo.service.UserService;
import com.example.demo.service.StorageService;





@RestController
public class FileController 
{
	
	@Autowired
	private StorageService storageService;
	
	@Autowired 
	private PostService postService;
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private PostRepo postRepo;
	
	@PostMapping("/file")
	public ResponseEntity<?> uploadImage(@RequestBody @RequestParam("postId") long postId,@RequestParam("file")MultipartFile file) throws IOException 
	  {
		  String uploadImage =storageService.uploadFile(file,postId);	
		  return ResponseEntity.ok().body(uploadImage);		
	  }
	
  	@GetMapping("/file/{postId}")
    public ResponseEntity<?> downloadFile(@PathVariable long postId)
  	    {
 
  		 Post post = postService.getPostById(postId).get();
  		 FileData fileDataObj=storageService.getById(postId).get();
         byte[] fileData=storageService.downloadFile(fileDataObj.getName());
    
         return ResponseEntity.status(HttpStatus.OK)
         .contentType(MediaType.valueOf("image/png"))
         .body(fileData);
	 
	     }
  
        
        @DeleteMapping("/file/{postId}")
        public void deleteFile(@RequestBody @RequestParam("postId") long postId)
        {
		       
		    		 Optional<Post> post = postService.getPostById(postId);
		        	 post.get().setMedialink("No Media File");
		             storageService.deleteFile(postId); 
		          

        }

}
