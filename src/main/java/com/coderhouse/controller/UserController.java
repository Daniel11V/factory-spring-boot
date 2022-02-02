package com.coderhouse.controller;

import com.coderhouse.model.request.UserRequest;
import com.coderhouse.model.response.UserResponse;
import com.coderhouse.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coder-house")
public class UserController {

    private final UserService service;

    @PostMapping("/user")
    public UserResponse createUser(
            @Validated @RequestBody UserRequest user) {
        return service.create(user);
    }

    @PutMapping("/user/{id}")
    public UserResponse updateUser(@PathVariable String id,
            @Validated @RequestBody UserRequest user) {
        return service.update(id, user);
    }

    @GetMapping("/user/all")
    public List<UserResponse> searchUser() {
        return service.searchAll();
    }
}
