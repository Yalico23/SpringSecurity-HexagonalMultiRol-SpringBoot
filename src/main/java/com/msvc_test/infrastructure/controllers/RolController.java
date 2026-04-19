package com.msvc_test.infrastructure.controllers;

import com.msvc_test.application.service.AuthService;
import com.msvc_test.domain.models.Rol;
import com.msvc_test.infrastructure.dto.request.RolDtoCreate;
import com.msvc_test.infrastructure.mapper.RolMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rols")
@RequiredArgsConstructor
public class RolController {

    private final AuthService authService;
    private final RolMapper rolMapper;

    @PostMapping
    public ResponseEntity<Rol> createRol(@Valid @RequestBody RolDtoCreate rol){
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.createRol(rolMapper.toModel(rol)));
    }

}
