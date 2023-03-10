package com.example.demo.service;
import com.example.demo.Model.Users;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		
		if(username.equals("abhi"))
		{
			return new User("abhi","454566",new ArrayList<>());
		}
		
		else if(!username.equals("abhi"))
			 {
			 
			  Optional<Users> user=userRepo.findById(Long.parseLong(username));
			  String password=user.get().getPassword();
			 
			  return new User(username,password,new ArrayList<>());
			     
			 }
		
		else
		{
			throw new UsernameNotFoundException("Username Not Found");
		}
		
		
		
		
	}
	

}
