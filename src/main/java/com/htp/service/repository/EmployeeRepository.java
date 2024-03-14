package com.htp.service.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htp.service.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    
} 
