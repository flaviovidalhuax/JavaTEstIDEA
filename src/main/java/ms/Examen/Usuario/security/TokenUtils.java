package ms.Examen.Usuario.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.security.SecureRandom;
import java.util.*;

public class TokenUtils {
    private final static String ACESS_TOKEN_SECRET="0hQSBeUoW6tVGLoK7NEdqRWEGlzu1rxEsjBRXrCecKc";
    private final static Long ACCESS_TOKEN_VALIDITY_SECOND=2_592_000L;

    public static String createToken(String login,String password){
        long expirationTime=ACCESS_TOKEN_VALIDITY_SECOND*1_000;
        Date expirationDate=new Date(System.currentTimeMillis()+expirationTime);

        Map<String,Object> extra=new HashMap<>();
        extra.put("login",login);

        return Jwts
                .builder()
                .setSubject(password)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACESS_TOKEN_SECRET.getBytes()))
                .compact();
    }
    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
        try {
            Claims claims=Jwts.parserBuilder()
                    .setSigningKey(ACESS_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            String password=claims.getSubject();

            return new UsernamePasswordAuthenticationToken(password,null, Collections.emptyList());
        }catch (JwtException e){
            return null;
        }
    }
}
