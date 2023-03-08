package com.example.demo.repo;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Post;
import com.example.demo.Model.User;



public interface PostRepo extends JpaRepository<Post,Long>{

}
