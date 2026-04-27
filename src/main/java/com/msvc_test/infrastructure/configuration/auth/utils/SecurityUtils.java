package com.msvc_test.infrastructure.configuration.auth.utils;

import com.msvc_test.domain.exceptions.UserNotAuthenticate;
import com.msvc_test.infrastructure.configuration.auth.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SecurityUtils {

    /**
     * Obtiene el ID del usuario actualmente autenticado.
     * */
    public UUID getCurrentUserId(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth == null || !auth.isAuthenticated()){
            throw new UserNotAuthenticate("User is not authenticated");
        }
        return ((CustomUserDetails) auth.getPrincipal()).getId();
    }

    public String getCurrentUserEmail(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth == null || !auth.isAuthenticated()){
            throw new UserNotAuthenticate("User is not authenticated");
        }
        return ((CustomUserDetails) auth.getPrincipal()).getUsername();
    }
}
