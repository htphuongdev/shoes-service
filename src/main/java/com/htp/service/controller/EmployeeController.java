package com.htp.service.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.htp.service.dto.request.CreateEmployeeRequest;
import com.htp.service.dto.request.UpdateEmployeeRequest;
import com.htp.service.model.Employee;
import com.htp.service.service.EmployeeService;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/api/employees")
    List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/api/employees/{employeeId}")
    Employee getEmployee(@PathVariable("employeeId") UUID employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping("/api/employees")
    Employee creatEmployee(@RequestBody CreateEmployeeRequest request) {
        return employeeService.creatEmployee(request);
    }

    @PutMapping("/api/employees/{employeeId}")
    Employee updatEmployee(@PathVariable("employeeId") UUID employeeId, @RequestBody UpdateEmployeeRequest request) {
        return employeeService.updatEmployee(employeeId, request);
    }

    @DeleteMapping("/api/employees/{employeeId}")
    String deleteEmployee(@PathVariable("employeeId") UUID employeeId) {
        employeeService.deleteEmployee(employeeId);
        return "Employee is deleted";
    }
}
