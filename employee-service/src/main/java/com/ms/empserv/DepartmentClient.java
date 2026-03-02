package com.ms.empserv;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ms.empserv.dto.DepartmentDTO;


@FeignClient(name = "department-service") 
public interface DepartmentClient {

	@GetMapping("/departments/{id}")
	DepartmentDTO getDepartment(@PathVariable Long id);
}
