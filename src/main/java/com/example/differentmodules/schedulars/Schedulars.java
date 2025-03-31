package com.example.differentmodules.schedulars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.differentmodules.dto.Employee;
import com.example.differentmodules.dto.Student;
import com.example.differentmodules.service.EmployeeService;
import com.example.differentmodules.service.StudentService;

@Component
public class Schedulars {
	@Autowired
	private EmployeeService employeeservice;
	@Autowired
	private StudentService studentservice;

	@Scheduled(cron = "0 0/1 * * * ?")
	public void addScheduler() {
		System.out.println("process started");
		Employee employee = new Employee();
		employee.setDept("ECE");

		employee.setName("NAVADEEP");
		employee.setSalary(1000.00);

		employeeservice.addEmployee(employee);
		System.out.println("process ended");

	
		System.out.println("2nd schedular started");
		Student stu = new Student();
		stu.setDepartment("eee");
		stu.setName("Ashok");
		studentservice.addStudent(stu);
		System.out.println("Schedular Ended");
	}
}
