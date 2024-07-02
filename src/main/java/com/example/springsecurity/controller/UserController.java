package com.example.springsecurity.controller;

import com.example.springsecurity.dto.AuthenticationResponce;
import com.example.springsecurity.dto.LoginDto;
import com.example.springsecurity.dto.UserDto;
import com.example.springsecurity.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.plaf.PanelUI;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponce> register(@RequestBody UserDto userDto){
        return ResponseEntity.ok((userService.register(userDto)));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponce> login(@RequestBody LoginDto loginDto){
        return ResponseEntity.ok(userService.authenticate(loginDto));
    }


}
