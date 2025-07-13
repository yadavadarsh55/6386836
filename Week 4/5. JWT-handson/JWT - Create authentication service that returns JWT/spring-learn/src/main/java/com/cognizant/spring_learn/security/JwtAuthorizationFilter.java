package com.cognizant.spring_learn.security;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthorizationFilter.class);
    private static final String SECRET_KEY_STRING = "mySuperSecretKeyForHS256Algorithm!12345";
    private static final Key SIGNING_KEY = Keys.hmacShaKeyFor(SECRET_KEY_STRING.getBytes(StandardCharsets.UTF_8));

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
        LOGGER.info("Start: JwtAuthorizationFilter constructor");
        LOGGER.debug("AuthenticationManager: {}", authenticationManager);
        LOGGER.info("End: JwtAuthorizationFilter constructor");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {
        LOGGER.info("Start: doFilterInternal()");
        String header = req.getHeader("Authorization");
        LOGGER.debug("Authorization Header: {}", header);

        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(req, res);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);

        if (authentication != null) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {

            SecurityContextHolder.clearContext();
        }

        chain.doFilter(req, res);
        LOGGER.info("End: doFilterInternal()");
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        LOGGER.debug("Start: getAuthentication()");
        String token = request.getHeader("Authorization");
        if (token != null) {
            try {
                Jws<Claims> jws = Jwts.parser()
                        .setSigningKey(SIGNING_KEY)
                        .build()
                        .parseClaimsJws(token.replace("Bearer ", ""));

                String user = jws.getBody().getSubject();
                LOGGER.debug("User from JWT: {}", user);

                if (user != null) {

                    List<GrantedAuthority> authorities = new ArrayList<>();
                    if ("user".equalsIgnoreCase(user)) {
                        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                    } else if ("admin".equalsIgnoreCase(user)) {
                        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                    }

                    LOGGER.debug("Authorities granted to {}: {}", user, authorities);
                    return new UsernamePasswordAuthenticationToken(user, null, authorities);
                }
            } catch (JwtException ex) {
                LOGGER.error("JWT validation failed: {}", ex.getMessage());

                return null;
            }
        }
        LOGGER.debug("End: getAuthentication() - No valid token found or parsing failed.");
        return null;
    }
}