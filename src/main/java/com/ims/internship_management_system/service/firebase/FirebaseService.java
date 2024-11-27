package com.ims.internship_management_system.service.firebase;

import com.ims.internship_management_system.model.dto.LoginRequest;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

@Slf4j
@Service
@RequiredArgsConstructor
public class FirebaseService {

    private final WebClient webClient;

    // Fetch the API key from the environment variable
    @Value("${firebase.api_key}")
    private String apiKey;

    private final String URL_TEMPLATE = "https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=";

    public SignupResponse signUp(LoginRequest login) {
        String urlApi = URL_TEMPLATE + apiKey; // Construct URL dynamically
        try {
            return webClient
                    .post()
                    .uri(urlApi)
                    .body(Mono.just(login), LoginRequest.class)
                    .retrieve()
                    .bodyToMono(SignupResponse.class)
                    .block();
        } catch (Exception e) {
            Logger logger = Logger.getLogger(this.getClass().getName());
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

//    public class RegisterFirebase()

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SignupResponse {
        private String kind;
        private String idToken;
        private String email;
        private String refreshToken;
        private String expiresIn;
        private String localId;
    }
}
