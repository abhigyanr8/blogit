package com.example.demo.service;

import com.example.demo.Model.Post;
import com.example.demo.Model.FileData;
import com.example.demo.repo.PostRepo;
import com.example.demo.repo.StorageRepository;
import com.example.demo.repo.UserRepo;
import com.example.demo.util.FileUtils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class StorageService {

    @Autowired
    private StorageRepository storageRepo;
    
    @Autowired
    private PostRepo postRepo;

    public String uploadFile(MultipartFile file,long postId) throws IOException 
    {
    	FileData fileData = storageRepo.save(FileData.builder()
                .name(file.getOriginalFilename()).postId(postId)
                .fileData(FileUtils.compressFile(file.getBytes())).build());
    	
    	Optional<Post> findPost=postRepo.findById(fileData.getPostId());
	    	 Post post=findPost.get();
	    	 post.setMedialink("localhost:8080/file/"+postId);
    	     postRepo.save(post);
        if (fileData != null) 
            {
                return "file uploaded successfully : " + file.getOriginalFilename();
            }
        return null;
    }

    public byte[] downloadFile(String fileName)
    {
    
           Optional<FileData> dbImageData = storageRepo.findByName(fileName);
           byte[] images=FileUtils.decompressFile(dbImageData.get().getFileData());
           return images;
    }
    
   public Optional<FileData> getById(long postId)
      {
	     return storageRepo.findById(postId);
      }
    
    public void deleteFile(long postId)
    {
    	storageRepo.deleteById(postId);
    	
    }
}
