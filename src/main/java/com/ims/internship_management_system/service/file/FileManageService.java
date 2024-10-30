package com.ims.internship_management_system.service.file;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class FileManageService {
    private static final String UPLOAD_DIRECTORY = String.valueOf(Paths.get(System.getProperty("user.dir"),
            "uploads"));
    private static final String STORAGE_DIRECTORY = String.valueOf(Paths.get(System.getProperty("user.dir"),
            "saves"));

    public String uploadFile(MultipartFile file) {
        try {
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path filePath = Paths.get(UPLOAD_DIRECTORY).resolve(fileName);

            // Ensure the upload directory exists
            Files.createDirectories(Paths.get(UPLOAD_DIRECTORY));

            // Save the file locally in the uploads folder
            Files.write(filePath, file.getBytes());
            return "Avatar uploaded successfully";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload avatar";
        }
    }

    public void saveFile(MultipartFile file) throws IOException {
        if (file == null) {
            throw new NullPointerException("File is null");
        }

        // Ensure the storage directory exists
        Files.createDirectories(Paths.get(STORAGE_DIRECTORY));

        File targetFile = new File(STORAGE_DIRECTORY + File.separator + file.getOriginalFilename());

        // Check if the file path matches the storage directory
        if (!Objects.equals(targetFile.getParent(), STORAGE_DIRECTORY)) {
            throw new SecurityException("Unsupported file name!");
        }

        // Copy the file to the target location, replacing any existing file
        Files.copy(file.getInputStream(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}
