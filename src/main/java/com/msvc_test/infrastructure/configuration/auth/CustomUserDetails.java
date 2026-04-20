package com.msvc_test.infrastructure.configuration.auth;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.UUID;

/**
 * CustomUserDetails es una clase que extiende de User, la cual es una implementación de UserDetails proporcionada por Spring Security.
 * Esta clase personalizada incluye un campo adicional 'id' de tipo UUID, que representa el identificador único del usuario en la base de datos. Al extender de User, CustomUserDetails hereda todas las propiedades y métodos necesarios para la autenticación y autorización, como el nombre de usuario, la contraseña, el estado de la cuenta, etc. Al agregar el campo 'id', podemos asociar fácilmente la información de autenticación con el registro del usuario en la base de datos, lo que facilita la gestión de usuarios y la implementación de funcionalidades adicionales que requieran el acceso al ID del usuario.
 */
@Getter
public class CustomUserDetails extends User {

    private final UUID id;

    public CustomUserDetails(UUID id, String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.id = id;
    }
}
