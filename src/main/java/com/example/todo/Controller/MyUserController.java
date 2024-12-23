package com.example.todo.Controller;


import com.example.todo.ApiResponse.ApiResponse;
import com.example.todo.Model.MyUser;
import com.example.todo.Service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class MyUserController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> addUser(@RequestBody @Valid MyUser myuser) {

        authService.adduser(myuser);

        return ResponseEntity.status(200).body(new ApiResponse("successfully added user"));

    }
}
