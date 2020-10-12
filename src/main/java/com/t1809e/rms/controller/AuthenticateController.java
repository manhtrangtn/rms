package com.t1809e.rms.controller;

import com.t1809e.rms.configuration.JwtProvider;
import com.t1809e.rms.configuration.MyUserDetail;
import com.t1809e.rms.dto.AuthenticateRequest;
import com.t1809e.rms.dto.AuthenticateResponse;
import com.t1809e.rms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@CrossOrigin
//@RequestMapping("api")
public class AuthenticateController {

    @Autowired
    private UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider tokenProvider;


    @PostMapping("/auth")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthenticateRequest loginRequest) {

        // Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken((MyUserDetail) authentication.getPrincipal());
        return new ResponseEntity<AuthenticateResponse>(new AuthenticateResponse(jwt, LocalDate.now()), HttpStatus.ACCEPTED);
    }
}

