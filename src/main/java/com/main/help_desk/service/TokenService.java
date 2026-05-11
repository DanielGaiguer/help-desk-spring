
package com.main.help_desk.service;
import com.main.help_desk.model.UsuarioDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;
    
    private SecretKey getSignKey(){
        byte[] keyBytes = Decoders.BASE64.decode(this.secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    
    public String getToken(UsuarioDTO usuario) {
        return Jwts.builder()
            .subject(usuario.getEmail())
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + 300000))
            .signWith(getSignKey())
            .compact();
    }
    
    public boolean validToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(getSignKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            throw  new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token expirado ou invalido");
        }
    }
    
    public Claims extrairClaims(String token) {
        return Jwts.parser()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
