package com.ms.empserv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.empserv.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
