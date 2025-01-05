package com.example.test_project.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeRequestDTO {

    private Long id;
    private String name;
    private String address;
    private String nic;
}
