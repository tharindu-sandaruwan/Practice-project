package com.example.test_project.service.impl;

import com.example.test_project.controller.DTO.EmployeeRequestDTO;
import com.example.test_project.exception.EmployeeNotFoundException;
import com.example.test_project.model.Employee;
import com.example.test_project.repository.EmployeeRepository;
import com.example.test_project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void saveEmployee(EmployeeRequestDTO employeeRequestDTO)throws EmployeeNotFoundException {

        Optional<Employee> employee = employeeRepository.findByNic(employeeRequestDTO.getNic());
        if (employee.isPresent()) {
            throw new EmployeeNotFoundException("Employee with nic " + employeeRequestDTO.getNic() + " already exists");

        }else {
            Employee emp = new Employee();
            emp.setName(employeeRequestDTO.getName());
            emp.setAddress(employeeRequestDTO.getAddress());
            emp.setNic(employeeRequestDTO.getNic());

            employeeRepository.save(emp);
        }

    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employeeRepository.delete(employee.get());
        }else {
            System.out.println("Employee not found");
        }
    }

}
