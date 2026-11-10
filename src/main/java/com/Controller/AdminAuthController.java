
package com.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.JWT.JwtService;
import com.Service.AdminService;

import comDTO.LoginRequestDto;
import comDTO.LoginResponseDto;

@RestController
@RequestMapping("/api/admin")
public class AdminAuthController {
	private final AdminService adminService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AdminAuthController(
            AuthenticationManager authenticationManager,
            JwtService jwtService,
            AdminService adminService) {

        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.adminService = adminService;
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody LoginRequestDto request) {

        adminService.createAdmin(
                request.getUsername(),
                request.getPassword()
        );

        return ResponseEntity.ok("Admin registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(
            @RequestBody LoginRequestDto request) {

        System.out.println("LOGIN API CALLED");

        System.out.println("BEFORE AUTHENTICATION");

        Authentication authentication =
                authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                    )
                );

        System.out.println("AUTHENTICATION SUCCESS");

        String token =
                jwtService.generateToken(authentication.getName());

        System.out.println("JWT TOKEN GENERATED");

        LoginResponseDto response = new LoginResponseDto();
        response.setToken(token);
        response.setTokenType("Bearer");

        return ResponseEntity.ok(response);
    }
}
