package com.daletcode.service;

import com.daletcode.dto.UserRequest;
import com.daletcode.dto.UserResponse;

import java.util.List;

public interface UserService {

    List<UserResponse> findAll();

    UserResponse findById(Long id);
    UserResponse create(UserRequest userRequest);

    UserResponse update(Long id, UserRequest userRequest);

    void delete(Long id);
}
