package com.example.demo.controller;

import java.util.List;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.JwtResponse;
import com.example.demo.Model.Jwtrequest;
import com.example.demo.Model.Users;
import com.example.demo.dto.UserRequest;
import com.example.demo.service.CustomUserDetailsService;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtUtil;

@RestController
public class UserController 
{
	@Autowired
	UserService userService;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsDervice;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	//to generate token
	  @PostMapping(value="/generate-token",produces = "application/json")
		public ResponseEntity<?> generateToken(@org.springframework.web.bind.annotation.RequestBody Jwtrequest jwtRequest ) throws Exception
		{
		 
		   System.out.println(jwtRequest);
			try
			   { 
				  this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));
			   } 
			catch (UsernameNotFoundException e) 
			{
				e.printStackTrace();
				throw new Exception("Username not present");
			
			}
			UserDetails userDetails = this.customUserDetailsDervice.loadUserByUsername(jwtRequest.getUsername());
			
			String token=this.jwtUtil.generateToken(userDetails);
			
			return ResponseEntity.ok(new JwtResponse(token));
			
		
		}
 
  //Post Mapping for adding the user.
	@PostMapping("/user")
	public Users add(@RequestBody @Valid UserRequest userRequest)
	{
		  return userService.addUser(userRequest);
	}
	
  //Get Mapping for all Users
	
	@GetMapping("/user")
	public List<Users> getAllUsers()
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
    
	@GetMapping("/user/{id}")
	public Optional<Users> getUserById(@PathVariable("id") long id)
	{
	    return userService.getUserbyId(id);
	}
	
	//Edit User Details
	@PutMapping( "/user/{id}" )
	public Users updateUser( @RequestParam("id") long id,@RequestBody @Valid UserRequest userrequest)
	{
		Users updatedUser=userService.updateUserById(id,userrequest);
        return updatedUser;
	}
}
