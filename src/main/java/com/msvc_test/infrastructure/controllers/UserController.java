package com.msvc_test.infrastructure.controllers;

import com.msvc_test.application.service.AuthService;
import com.msvc_test.domain.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final AuthService authService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.createUser(user));
    }

    // Ejemplo de endpoint protegido para crear un proyecto, solo accesible por usuarios con rol ADMIN NO ROLE_ADMIN
//    @PreAuthorize("hasAuthority('ADMIN')")
//    @PostMapping()
//    public ResponseEntity<Project> responseEntity(@RequestBody Project project){
//        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.createProject(project));
//    }

}
