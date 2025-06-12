package com.tuorjp.login_jwt.controller;

import com.tuorjp.login_jwt.model.Test;
import com.tuorjp.login_jwt.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
    private final TestRepository testRepository;

    @GetMapping
    public List<Test> findAll() {
        return testRepository.findAll();
    }
}
