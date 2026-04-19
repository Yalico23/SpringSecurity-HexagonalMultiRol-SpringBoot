package com.msvc_test.infrastructure.dto.request;

import com.msvc_test.domain.models.TypeRols;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RolDtoCreate {
    @NotNull
    private TypeRols typeRols;

}
