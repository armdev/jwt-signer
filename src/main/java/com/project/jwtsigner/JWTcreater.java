package com.project.jwtsigner;

import io.jsonwebtoken.Claims;

/**
 *
 * @author armdev
 */
public class JWTcreater {

    public static void main(String[] args) {
        final String userId = "avatar";
        final String email = "javatar@gmail.com";

        long for_hours = 14400000;//expiration date

        JWTcreater creater = new JWTcreater();
        String token = creater.tokenGenerator(userId, email, email, for_hours);
        System.out.println("First token " + token);
        boolean check = creater.checkUserCredentials(token, userId, email);
        System.out.println("Is user verified ? " + check);

    }

    private String tokenGenerator(String userId, String email, String row, long time) {
        String token = JWTSigner.createJWTToken(userId, email, row, time);
        return token;
    }

    private boolean checkUserCredentials(String token, String userId, String email) {
        Claims claims = JWTSigner.verifyJWT(token, userId, email);
        return claims.getId().equalsIgnoreCase(userId);

    }
    // "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJhdmF0YXIiLCJpYXQiOjE1MTIwMzQ1NTMsInN1YiI6ImphdmF0YXJAZ21haWwuY29tIiwiaXNzIjoiamF2YXRhckBnbWFpbC5jb20iLCJleHAiOjMwMjQwNjkxMDZ9.1wJhFe1xi099vlDi67EkoSarOW7lF5TTBeQKRHt-6uU"
}
