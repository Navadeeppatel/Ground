package com.example.differentmodules.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.differentmodules.dto.Student;

public interface StudentRepo  extends JpaRepository<Student, Integer>{

	Optional<Student> findById(Integer id) ;
	
	
	
    
}
