package ru.severstal.notes.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    String saveImage(MultipartFile image);
    void deleteImage(String imagePath);
}