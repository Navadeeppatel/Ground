package com.example.differentmodules.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.differentmodules.dto.Employee;
import com.example.differentmodules.service.EmployeeService;

@RestController
@RequestMapping("/api/") // application processing interface used in class level
public class EmpController {

	@Autowired
	public EmployeeService employeeService ;

	@GetMapping("employee")
	public Employee employee() {
		return employeeService.addEmployee(null);
	}

	@GetMapping("getEmployee")
	public List<Employee> getEmployee() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("sum/{a}/{b}") // this method in method mapping only .
	public int sum(@PathVariable int a, @PathVariable int b) {// parameters are given
		return (a + b);
	}

	@GetMapping("sub/{a}/{b}")
	public int sub(@PathVariable int a, @PathVariable int b) {
		return (a - b);
	}

	@GetMapping("mul/{a}/{b}")
	public int mul(@PathVariable int a, @PathVariable int b) {
		return (a * b);
	}

	@GetMapping("div//{a}/{b}")

	public int div(@PathVariable int a, @PathVariable int b) {
		return (a / b);

	}

	@GetMapping("addition")
	public int addition(@RequestParam int a, @RequestParam int b) {
		return (a + b);
	}

	@GetMapping("Substraction")
	public int Substraction(@RequestParam int a, @RequestParam int b) {
		return (a - b);
	}

	@GetMapping("con")
	public String con(@RequestParam String a, @RequestParam int b) {
		return (a + b);
	}

	@GetMapping("value")
	public String value(@RequestParam String a, @RequestParam int b) {
		return (a + b);
	}
	
	@GetMapping("findByid/{id}/{salary}")
	public Employee getEmployeesById1(@RequestParam(required = false, value = "id") Integer id,
			@RequestParam Double salary) {
		return employeeService.findById(id, salary);
	

}
}
