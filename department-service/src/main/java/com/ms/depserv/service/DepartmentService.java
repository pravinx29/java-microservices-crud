package com.ms.depserv.service;

import java.util.List;

import com.ms.depserv.entity.Department;

public interface DepartmentService {

	Department createDepartment(Department department);

	Department getDepartmentById(Long id);

	List<Department> getAllDepartments();

	Department updateDepartment(Long id, Department department);

	void deleteDepartment(Long id);
}
