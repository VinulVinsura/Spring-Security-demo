package com.example.springsecurity.service;

import com.example.springsecurity.dto.AuthenticationResponce;
import com.example.springsecurity.dto.LoginDto;
import com.example.springsecurity.dto.UserDto;
import com.example.springsecurity.entity.User;
import com.example.springsecurity.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final ModelMapper modelMapper;

    public AuthenticationResponce register(UserDto userDto){
        User user=new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setUserRole(userDto.getUserRole());
        User savedUser = userRepo.save(user);
        String toke = jwtService.generateToke(savedUser);
        return new AuthenticationResponce(toke);

    }

    public AuthenticationResponce authenticate(LoginDto loginDto){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()
                )
        );
        User user = userRepo.findByUsername(loginDto.getUsername()).orElseThrow();
        String toke = jwtService.generateToke(user);
        return new AuthenticationResponce(toke);

    }


}

