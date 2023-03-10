package com.example.demo.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "FileData")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileData 
{
    @Id
    private long postId;
    private String name;
    private String mediaLink;
    @Lob
    @Column(name = "filedata",length = 1000)
    private byte[] fileData;
}
