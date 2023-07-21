package com.example.MicroservicesApplication.dao;

import com.example.MicroservicesApplication.dto.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PhotoDAO {

    void save(Photo photo);

    void saveImage(MultipartFile imageFile) throws IOException;
}
