package com.example.immoluxe.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    private static final String SECRET_KEY="yIiqewm3ugZKdrlFyI2YXO7/G8jP2n4iBQ/NPKPi4veNG8t7uYLHiU+q3n2kLfLw" ;
            ;

    public String extractUserName(String token) {
        return null;
    }
    private Claims extractClaims(String token) {
        return Jwts.parser().setSigningKey("immoluxe").parseClaimsJws(token).getBody();
    }
}
