package com.example.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName="build")
@NoArgsConstructor
public class UserRequest 
{
	@NotNull(message="Name cant be Blank")
	private String name;
	@NotNull(message="Email cant be Blank")
	@Email(message=" Email should be in proper format!!!")
	private String email;
	@NotNull(message="Password cant be Blank")
	private String password;
	@NotNull(message="About cant be Blank")
	private String about;


}
