package com.example.demo.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Post;




public interface PostRepo extends JpaRepository<Post,Long>{

}
