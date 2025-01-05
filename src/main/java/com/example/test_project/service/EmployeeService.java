package com.example.test_project.service;

import com.example.test_project.controller.DTO.EmployeeRequestDTO;
import com.example.test_project.model.Employee;

import java.util.List;

public interface EmployeeService {

    void saveEmployee(EmployeeRequestDTO employeeRequestDTO);

    List<Employee> getAllEmployees();

    void deleteEmployee(Long id);
}
