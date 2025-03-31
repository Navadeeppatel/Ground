package com.example.differentmodules.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.differentmodules.dto.Employee;
import com.example.differentmodules.dto.Student;

public interface EmpExpRepo extends JpaRepository<Employee, Integer> {

	Optional<Employee> findById(Integer id) ;
	
	
	
	
}
