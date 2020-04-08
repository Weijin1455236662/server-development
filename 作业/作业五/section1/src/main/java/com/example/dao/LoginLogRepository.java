package com.example.dao;

import com.example.domain.LoginLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginLogRepository extends JpaRepository<LoginLog,Long> {

    LoginLog save(LoginLog loginLog);
}
