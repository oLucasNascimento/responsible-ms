package com.sportsfinance.responsible.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.sportsfinance.responsible.api.dto.AuthenticateResponsibleDTO;
import com.sportsfinance.responsible.domain.model.Responsible;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
@Setter
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(AuthenticateResponsibleDTO responsible) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(responsible.getEmail())
                    .withExpiresAt(this.generateExpirationDate())
                    .sign(algorithm);
            System.out.println(token + " ########## token");
            return token;
        } catch (JWTCreationException ex) {
            throw new RuntimeException("Error while generation token", ex);
        }
    }

    private Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(10).toInstant(ZoneOffset.of("-03:00"));
    }


}
