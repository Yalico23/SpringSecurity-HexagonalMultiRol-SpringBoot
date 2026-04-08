package com.msvc_test.infrastructure.configuration.auth;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Clase abstracta que actúa como un creador de objetos SimpleGrantedAuthority a partir de JSON.
 * Esta clase utiliza la anotación @JsonCreator para indicar que el constructor debe ser utilizado
 * para crear instancias de SimpleGrantedAuthority a partir de datos JSON, específicamente a partir de una propiedad "authority".
 * La propiedad "authority" se espera que contenga el nombre del rol o autoridad que se desea representar.
 * Esta clase es útil para deserializar objetos SimpleGrantedAuthority desde JSON, permitiendo que las autoridades se representen correctamente en la aplicación de seguridad.
 * */
public abstract class SimpleGrantedAuthorityJsonCreator {
    @JsonCreator
    public SimpleGrantedAuthorityJsonCreator(@JsonProperty("authority") String role) {

    }
}
