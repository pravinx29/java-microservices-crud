package com.ms.depserv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.depserv.entity.Department;
import com.ms.depserv.service.DepartmentService;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

	@Autowired
	private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping
    public Department create(@RequestBody Department department) {
        return service.createDepartment(department);
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable Long id) {
        return service.getDepartmentById(id);
    }

    @GetMapping
    public List<Department> getAll() {
        return service.getAllDepartments();
    }

    @PutMapping("/{id}")
    public Department update(
            @PathVariable Long id,
            @RequestBody Department department) {
        return service.updateDepartment(id, department);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteDepartment(id);
    }
}
