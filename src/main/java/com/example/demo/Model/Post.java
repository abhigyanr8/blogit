package com.example.demo.Model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName="build")
@Entity
public class Post 
{
	@Id

	private long id;
	private String title;
	private String content;
	private long userId;
	private String medialink;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="pc_fid" ,referencedColumnName="id")
	List<Comment> comments = new ArrayList<>();

}
