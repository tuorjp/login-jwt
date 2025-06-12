package com.tuorjp.login_jwt.repository;

import com.tuorjp.login_jwt.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
}
