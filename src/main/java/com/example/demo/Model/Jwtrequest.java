package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



public class Jwtrequest 
{
	private String username;
    private String password;
    
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Jwtrequest(String username, String password) {
		
		this.username = username;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Jwtrequest [username=" + username + ", password=" + password + "]";
	}
	

}
