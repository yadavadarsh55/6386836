package com.cognizant.spring_learn.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    private static final String SECRET_KEY_STRING = "mySuperSecretKeyForHS256Algorithm!12345";

    private static final Key SIGNING_KEY = Keys.hmacShaKeyFor(SECRET_KEY_STRING.getBytes(StandardCharsets.UTF_8));

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start: authenticate()");
        LOGGER.debug("Authorization Header: {}", authHeader);

        String user = getUser(authHeader);
        LOGGER.debug("Authenticated User: {}", user);

        String token = generateJwt(user);
        LOGGER.debug("Generated JWT: {}", token);

        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        LOGGER.info("End: authenticate()");
        return response;
    }

    private String getUser(String authHeader) {
        LOGGER.debug("Start: getUser()");
        String base64Credentials = authHeader.substring("Basic ".length()).trim();
        byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(decodedBytes);
        LOGGER.debug("Decoded Credentials: {}", credentials);

        String user = credentials.split(":")[0];
        LOGGER.debug("Extracted User: {}", user);
        LOGGER.debug("End: getUser()");
        return user;
    }

    private String generateJwt(String user) {
        LOGGER.debug("Start: generateJwt() for user: {}", user);

        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);
        builder.setIssuedAt(new Date());
        builder.setExpiration(new Date((new Date()).getTime() + 1200000));

        builder.signWith(SIGNING_KEY, SignatureAlgorithm.HS256);

        String token = builder.compact();
        LOGGER.debug("End: generateJwt() - Token generated.");
        return token;
    }
}