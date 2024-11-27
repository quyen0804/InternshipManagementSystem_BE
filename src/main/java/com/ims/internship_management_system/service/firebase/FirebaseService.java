package com.ims.internship_management_system.service.firebase;

import com.ims.internship_management_system.exception.IMSRuntimeException;
import com.ims.internship_management_system.model.dto.LoginRequest;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
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

    private final String SIGNUP_URL = "https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=";
    private final String SIGNIN_URL = "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=";

    public SignUpResponse signUp(LoginRequest login) {
        String urlApi = SIGNUP_URL + apiKey; // Construct URL dynamically
        try {
            return webClient
                    .post()
                    .uri(urlApi)
                    .body(Mono.just(login), LoginRequest.class)
                    .retrieve()
                    .bodyToMono(SignUpResponse.class)
                    .block();
        } catch (Exception e) {
            Logger logger = Logger.getLogger(this.getClass().getName());
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public SignInResponse signIn(LoginRequest login) {
        String urlApi = SIGNIN_URL + apiKey;
        try {
            return webClient
                    .post()
                    .uri(urlApi)
                    .body(Mono.just(login), LoginRequest.class)
                    .retrieve()
                    .bodyToMono(SignInResponse.class)
                    .block();
        } catch (Exception e) {
            Logger logger = Logger.getLogger(this.getClass().getName());
            System.out.println(e.getMessage());
            throw new IMSRuntimeException(HttpStatus.NOT_FOUND, "Sign in failed. Recheck your " +
                    "username and password.");
        }
    }




    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SignUpResponse {
        private String kind;
        private String idToken;
        private String email;
        private String refreshToken;
        private String expiresIn;
        private String localId;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SignInResponse {
        private String kind;
        private String localId;
        private String email;
        private String displayName;
        private String idToken;
        private boolean register;
    }
}
