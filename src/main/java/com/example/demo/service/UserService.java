package com.example.demo.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.User;
import com.example.demo.dto.UserRequest;
import com.example.demo.repo.UserRepo;

@Service
public class UserService 
{
	
	 @Autowired
	 UserRepo userRepo;
	 
	 
	 
	//To add user
	  
	   public User addUser(UserRequest userRequest)
	     {
		     
		       long id =  new Date().getTime();
		       User user = User.build(id,userRequest.getName(),userRequest.getEmail(),userRequest.getPassword(),userRequest.getAbout(),null);
		       System.out.println(id);
		       System.out.println(new Date().getTime());
		       return userRepo.save(user);
	     }
	   
	//To List All Users
	   
	
		public List<User>getAllUsers()
		{
			return userRepo.findAll();
		}
		
	//To get User By Id
		
		
		public Optional<User> getUserbyId(long id)
		{
			return userRepo.findById(id);
		}
		
	//To delete User By Id
				public void deleteUserById(long id)
				{
					userRepo.deleteById(id);
				
				}
    //To update User
				public User updateUserById(long id,UserRequest userRequest) 
				{
					  
					  User user = User.build(id,userRequest.getName(),userRequest.getEmail(),userRequest.getPassword(),userRequest.getAbout(),null);
					  return userRepo.save(user);
					
				}
		
	  

}
