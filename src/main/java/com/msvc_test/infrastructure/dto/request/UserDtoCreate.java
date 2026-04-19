package com.msvc_test.infrastructure.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoCreate implements Serializable {
    @NotNull
    @NotBlank
    String name;
    @Email
    @NotBlank
    String email;
    @NotNull
    @NotBlank
    String password;
    boolean admin;
}