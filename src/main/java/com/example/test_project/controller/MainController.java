package com.example.test_project.controller;

import com.example.test_project.controller.DTO.EmployeeRequestDTO;
import com.example.test_project.exception.EmployeeNotFoundException;
import com.example.test_project.model.Employee;
import com.example.test_project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/employees")
    public void save(@RequestBody EmployeeRequestDTO employeeRequestDTO) throws EmployeeNotFoundException {
        employeeService.saveEmployee(employeeRequestDTO);
    }

    @GetMapping(value = "/employees")
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @DeleteMapping(value = "/employees/{employee-id}")
    public void deleteEmployee(@PathVariable ("employee-id") Long id) {
        employeeService.deleteEmployee(id);
    }
}
