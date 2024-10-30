package com.ims.internship_management_system.controller;

import com.ims.internship_management_system.service.file.FileManageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequiredArgsConstructor
@RestController
public class FileManagerController {
    private final FileManageService fileManageService;
    private static final Logger log = Logger.getLogger(FileManagerController.class.getName());

    @PostMapping("/upload-file")
    public boolean uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            fileManageService.saveFile(file);
            return true;
        } catch (IOException e) {
            log.log(Level.SEVERE, "Exception during upload",e);
        }
        return false;
    }

}
