package com.ims.internship_management_system.configs.firebase;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "firebase")
@Getter
@Setter
public class FirebaseProperties {
    @Value("${firebase.api_key")
    private String apiKey;
}
