package com.example.Placement.Management.System.exception;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExceptionRepository extends JpaRepository<ExceptionLog, Long> {

    List<ExceptionLog> findByExceptionType(String exceptionType);
    List<ExceptionLog> findByStatus(String status);
    List<ExceptionLog> findByUserId(Long userId);
}

