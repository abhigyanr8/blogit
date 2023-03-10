package com.example.demo.repo;

import com.example.demo.Model.FileData;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StorageRepository extends JpaRepository<FileData,Long> {


    Optional<FileData> findByName(String fileName);

	List<FileData> findByPostId(long postId);
}
