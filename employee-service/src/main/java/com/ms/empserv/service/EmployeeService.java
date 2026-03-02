package com.ms.empserv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ms.empserv.DepartmentClient;
import com.ms.empserv.dto.DepartmentDTO;
import com.ms.empserv.dto.EmployeeResponse;
import com.ms.empserv.entity.Employee;
import com.ms.empserv.exception.EmployeeNotFoundException;
import com.ms.empserv.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	@Autowired
	private DepartmentClient departmentClient;

	public Employee save(Employee employee) {
		return repository.save(employee);
	}

	public Employee getById(Long id) {
		return repository.findById(id).orElseThrow();
	}

	public List<Employee> getAll() {
		return repository.findAll();
	}

	public ResponseEntity<EmployeeResponse> getEmployeeWithDepartment(Long id) {
		try {
			Employee employee = repository.findById(id).orElseThrow();
			DepartmentDTO department = departmentClient.getDepartment(employee.getDepartmentId());

			EmployeeResponse employeeResponse = new EmployeeResponse(employee, department);
			return ResponseEntity.ok(employeeResponse);
		} catch (Exception exception) {
			throw new EmployeeNotFoundException("Employee not found");
		}
	}
}
