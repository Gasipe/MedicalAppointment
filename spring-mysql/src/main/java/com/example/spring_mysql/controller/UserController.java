package com.example.spring_mysql.controller;

import com.example.spring_mysql.dto.UserRequestDTO;
import com.example.spring_mysql.dto.UserResponseDTO;
import com.example.spring_mysql.service.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserController {
    public final UserServiceImpl userService;

    public  UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findUserById(@RequestParam UUID id) {
        UserResponseDTO find = userService.findById(id);
        return ResponseEntity.ok(find);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        List<UserResponseDTO> find = userService.findAll();
        return ResponseEntity.ok(find);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO request) {
        UserResponseDTO save = userService.create(request);
        return ResponseEntity.ok(save);
    }


}
