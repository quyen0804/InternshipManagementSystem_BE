package com.ims.internship_management_system.configs.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;
import com.google.cloud.storage.Bucket;
import org.springframework.beans.factory.annotation.Value;

import java.io.FileInputStream;
import java.io.IOException;

public class FirebaseConfig {
    @Value("${firebase.path}")
    private String path;

    public void initialize() throws IOException {

        // Replace with the actual path to your Firebase service account key JSON file
        try (FileInputStream serviceAccount = new FileInputStream(path)) {
            // Set Firebase options
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.getApplicationDefault())
//                    .setDatabaseUrl("https://<DATABASE_NAME>.firebaseio.com/")
                    .build();

            FirebaseApp.initializeApp(options);

            // Access the storage bucket
            Bucket bucket = StorageClient.getInstance().bucket();
            System.out.println("Bucket: " + bucket.getName());
        }

    }
}
