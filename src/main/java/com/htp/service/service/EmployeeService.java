package com.htp.service.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htp.service.dto.request.CreateEmployeeRequest;
import com.htp.service.dto.request.UpdateEmployeeRequest;
import com.htp.service.model.Employee;
import com.htp.service.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;



    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployee(UUID employeeId) {
        var optionalEmploy = employeeRepository.findById(employeeId);
        return optionalEmploy.get();
    }

    public Employee creatEmployee(CreateEmployeeRequest request) {
        Employee employee = new Employee();

        employee.setCode(request.getCode());
        employee.setPassword(request.getPassword());
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        

        return employeeRepository.save(employee); 
    }

    public Employee updatEmployee(UUID employeeId, UpdateEmployeeRequest request) {
        Employee employee = getEmployee(employeeId);

        employee.setCode(request.getCode());
        employee.setPassword(request.getPassword());
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(UUID employeeId) {
        if (employeeId != null) {
            employeeRepository.deleteById(employeeId);
        }
    }
}
