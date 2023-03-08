package com.example.demo.repo;



import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.User;



public interface UserRepo extends JpaRepository<User,Long>{

}
