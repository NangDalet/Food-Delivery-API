package com.daletcode.controller;

import com.daletcode.dto.UserRequest;
import com.daletcode.dto.UserResponse;
import com.daletcode.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value ="/v1/users",consumes = "application/json",produces = "application/json")
    private ResponseEntity<UserResponse> create(@RequestBody UserRequest userRequest){

        //log.info("Intercept request create new user v1 with request: {}",userRequest);
        userService.create(userRequest);

        return ResponseEntity.ok().build();
    }

}
