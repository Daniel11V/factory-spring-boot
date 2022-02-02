package com.coderhouse.service;

import com.coderhouse.model.request.UserRequest;
import com.coderhouse.model.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse create(UserRequest request);
    UserResponse update(String id, UserRequest request);
    List<UserResponse> searchAll();
    UserResponse searchById(String id);
}
