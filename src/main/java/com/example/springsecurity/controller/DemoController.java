package com.example.springsecurity.controller;

import com.example.springsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {
    private final UserService userService;

    @GetMapping("/demo")
    public ResponseEntity<String> demo(){
        return ResponseEntity.ok("Hello from Secured URL");
    }

    @GetMapping("/admin_only")
    public ResponseEntity<String> AdminMethod(){
        return ResponseEntity.ok("Admin Only URL");
    }


}
