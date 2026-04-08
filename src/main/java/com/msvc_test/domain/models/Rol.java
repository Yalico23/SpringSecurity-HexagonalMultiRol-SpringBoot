package com.msvc_test.domain.models;

import lombok.*;

import java.util.UUID;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rol {

    private UUID id;
    private TypeRols typeRols;

}
