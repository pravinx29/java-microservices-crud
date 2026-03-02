package com.ms.depserv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.depserv.entity.Department;
import com.ms.depserv.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private final DepartmentRepository repository;

	public DepartmentServiceImpl(DepartmentRepository repository) {
		this.repository = repository;
	}

	@Override
	public Department createDepartment(Department department) {
		return repository.save(department);
	}

	@Override
	public Department getDepartmentById(Long id) {
		return repository.findById(id).orElseThrow();
	}

	@Override
	public List<Department> getAllDepartments() {
		return repository.findAll();
	}

	@Override
	public Department updateDepartment(Long id, Department department) {
		Department existing = getDepartmentById(id);
		existing.setName(department.getName());
		existing.setCode(department.getCode());
		existing.setDescription(department.getDescription());
		return repository.save(existing);
	}

	@Override
	public void deleteDepartment(Long id) {
		repository.deleteById(id);
	}

}
