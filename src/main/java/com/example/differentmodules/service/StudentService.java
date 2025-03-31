package com.example.differentmodules.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.differentmodules.dto.Student;
import com.example.differentmodules.repo.StudentRepo;

@Service
public class StudentService {
	@Autowired
	private StudentRepo studentrepo;

	public Student addStudent(Student student) {
		return studentrepo.save(student);

	}

	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentrepo.findAll();
	}

	public void deletestudentid(Integer id) {
		// TODO Auto-generated method stub
		try {
			studentrepo.deleteById(id);
		} catch (Exception e) {
			System.out.println("not able to delete employee");
		}

	}

}
