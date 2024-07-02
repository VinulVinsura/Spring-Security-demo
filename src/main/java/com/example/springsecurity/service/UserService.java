package com.example.springsecurity.service;


import com.example.springsecurity.dto.AuthenticationResponce;
import com.example.springsecurity.dto.LoginDto;
import com.example.springsecurity.dto.UserDto;

public interface UserService {
     AuthenticationResponce register(UserDto userDto);
     AuthenticationResponce authenticate(LoginDto loginDto);
}
