package com.msvc_test.infrastructure.configuration.auth;

import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;

/**
* Configuración para la generación y validación de tokens JWT (JSON Web Tokens).
* Esta clase define constantes relacionadas con la seguridad de los tokens JWT, como la clave secreta
* */
public class TokenJwtConfig {
    public static final SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build(); // Genera una clave secreta para firmar los tokens JWT
    public static final String PREFIX_TOKEN = "Bearer ";
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String CONTENT_TYPE = "application/json";
}
