package com.soCompany.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Service
@RequiredArgsConstructor
public class ImageService {

    @Value("D:\\IdeaProjects\\JavaProjects\\SoSad\\LibrayWeb\\images\\user\\profileImages")
    private String userProfilePicturesBucket;

    @SneakyThrows
    public void uploadUserProfilePicture(String imagePath, InputStream content) {
        Path fullPath = Path.of(userProfilePicturesBucket, imagePath);

        try(content) {
            Files.createDirectories(fullPath.getParent());
            Files.write(fullPath, content.readAllBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        }
    }
}
