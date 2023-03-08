package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.User;
import com.example.demo.dto.UserRequest;
import com.example.demo.service.UserService;

@RestController
public class UserController 
{
	@Autowired
	UserService userService;
 
  //Post Mapping for adding the user.
	@PostMapping("/user")
	public User add(@RequestBody @Valid UserRequest userRequest)
	{
		  return userService.addUser(userRequest);
	}
	
  //Get Mapping for all Users
	
	@GetMapping("/User")
	public List<User> getAllUsers()
	{
		return userService.getAllUsers();
	}
	
  //Delete Mapping for User
	
	@DeleteMapping("/user/{id}")
	public void deleteBuyerById(@PathVariable("id") long id) 
	{	
		
	
		userService.deleteUserById(id);
		
	}
	//Get User By Id
    
	@GetMapping("/{id}")
	public Optional<User> getUserById(@PathVariable("id") long id)
	{
	    return userService.getUserbyId(id);
	}
	
	//Edit User Details
//	@PutMapping( "/{id}" )
//	public User updateUser( @RequestParam("id") long id,@RequestBody @Valid UserRequest userrequest)
//	{
//		User updatedUser=userService.updateUserById(id,userrequest);
//        return updatedUser;
//	}
}
