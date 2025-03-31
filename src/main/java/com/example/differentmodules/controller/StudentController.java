package com.example.differentmodules.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.differentmodules.dto.Student;
import com.example.differentmodules.service.StudentService;

@RestController
public class StudentController {

	@GetMapping("/sub1")
	public String sub1() {
		return " we the string data";

	}
	@Autowired
	private StudentService studentservice;
	
	@PostMapping("/studentdetails")
	public Student addStudents( @RequestBody Student student) {
		System.out.println(student.getName()+"===="+student.getDepartment());
		return studentservice.addStudent(student);

}
	@GetMapping("/findstudents")
	public List<Student> getAllStudents() {
		return studentservice.getAllStudents();
	}
	@DeleteMapping("/deletestudent/{id}")
	public void deletestudent(@PathVariable Integer id) {
		studentservice.deletestudentid(id);
	}
	
}
