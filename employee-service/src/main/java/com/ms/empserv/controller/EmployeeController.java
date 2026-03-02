package com.ms.empserv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.empserv.dto.EmployeeResponse;
import com.ms.empserv.entity.Employee;
import com.ms.empserv.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return service.save(employee);
    }

    @GetMapping("/{id}")
    public Employee get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAll();
    }
    
    @GetMapping("/{id}/details")
    public ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable Long id) {
        return service.getEmployeeWithDepartment(id);
    }
}
