package com.tuorjp.login_jwt.controller;

import com.tuorjp.login_jwt.dto.AuthenticationDTO;
import com.tuorjp.login_jwt.dto.LoginResponseDTO;
import com.tuorjp.login_jwt.dto.RegisterDTO;
import com.tuorjp.login_jwt.model.User;
import com.tuorjp.login_jwt.repository.UserRepository;
import com.tuorjp.login_jwt.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login, data.password);

        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        loginResponseDTO.setToken(token);

        return ResponseEntity.ok(loginResponseDTO);
    }

    @PostMapping("register")
    public ResponseEntity register(@RequestBody RegisterDTO data) {
        if(this.userRepository.findByLogin(data.login) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = passwordEncoder.encode(data.password);
        User newUser = new User(data.getLogin(), encryptedPassword, data.getRole());

        userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }
}
