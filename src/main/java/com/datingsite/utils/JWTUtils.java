package com.datingsite.utils;


import com.datingsite.constants.Constants;
import com.datingsite.dto.SuccessfulLoginData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

public class JWTUtils {

    public static Claims decodeJWT(String jwt) {
        //This line will throw an exception if it is not a signed JWS (as expected)
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(Constants.JWT_KEY))
                .parseClaimsJws(jwt).getBody();
        return claims;
    }

    public static String createJWT(SuccessfulLoginData successfulLoginData) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonUserData = objectMapper.writeValueAsString(successfulLoginData);
        String strUserId = String.valueOf(successfulLoginData.getId());
        String strNickName = String.valueOf(successfulLoginData.getNickName());
        String strAge = String.valueOf(successfulLoginData.getAge());
        String token = createJWT(strUserId , strNickName , jsonUserData, strAge , 0);
        return token;
    }

    private static String createJWT(String id, String nickName, String subject, String age , long ttlMillis) {

        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(Constants.JWT_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .setIssuer(nickName)
                .setAudience(age)
                .signWith(signatureAlgorithm, signingKey);

        //if it has been specified, let's add the expiration
        if (ttlMillis > 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }

    public static Integer getIdByToken(String token) {
        Claims claims = decodeJWT(token);
        return Integer.parseInt(claims.getId());
    }

    public static Integer validateToken(String token) throws Exception {
        Claims claims = decodeJWT(token);
        return Integer.parseInt(claims.getId());
    }
}
