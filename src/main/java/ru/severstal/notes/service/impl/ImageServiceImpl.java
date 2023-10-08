package ru.severstal.notes.service.impl;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.severstal.notes.exception.ImageDeletionException;
import ru.severstal.notes.service.ImageService;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageServiceImpl implements ImageService {

    private static final String IMAGE_UPLOAD_DIR = "src/main/resources/static/images/";

    @SneakyThrows
    @Override
    public String saveImage(MultipartFile image) {
        String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();

        Path imagePath = Paths.get(IMAGE_UPLOAD_DIR + fileName);

        try (var bis = new BufferedInputStream(image.getInputStream());
             var bos = new BufferedOutputStream(new FileOutputStream(imagePath.toFile()))) {

            var buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        }

        return "/images/" + fileName;
    }

    @Override
    public void deleteImage(String imagePath) {
        if (imagePath != null && !imagePath.isEmpty()) {
            String fullPath = IMAGE_UPLOAD_DIR + imagePath.substring("/images/".length());
            try {
                Files.deleteIfExists(Paths.get(fullPath));
            } catch (IOException e) {
                throw new ImageDeletionException("Ошибка удаления изображения из каталога", e);
            }
        }
    }
}