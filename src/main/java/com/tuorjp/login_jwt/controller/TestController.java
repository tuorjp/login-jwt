package com.tuorjp.login_jwt.controller;

import com.tuorjp.login_jwt.model.Test;
import com.tuorjp.login_jwt.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Test save(@RequestBody Test test) {
        test.setId(null);
        return testRepository.save(test);
    }
}
