package bd.edu.seu.quiz;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    private final byte[] JWT_SECRET = "123456789123456789123456789123456789123456789123456789123456789123456789".getBytes(StandardCharsets.UTF_8);
    private final SecretKey JWT_SECRET_KEY = Keys.hmacShaKeyFor(JWT_SECRET);

    public String generateToken(String username) {
        return String.valueOf(Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 5000000))
                .signWith(JWT_SECRET_KEY));
    }

    public Claims parseToken(String token) {
        return Jwts.parser()
                .verifyWith(JWT_SECRET_KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

}
