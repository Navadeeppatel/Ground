package com.example.differentmodules.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.differentmodules.dto.Employee;
import com.example.differentmodules.service.EmployeeService;

@RestController
@RequestMapping
public class EmpExamController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/addemployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		System.out.println(employee.getName() + "=====" + employee.getSalary() + "=====" + employee.getDept());
		return employeeService.addEmployee(employee);
	}

	@PostMapping("/addemployees")
	public List<Employee> addEmployees(@RequestBody List<Employee> employees) {
		// System.out.println(employee.getName() + "=====" + employee.getSalary() +
		// "=====" + employee.getDept());
		return employeeService.addEmployees(employees);
	}

	@GetMapping("/getemployees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public void deleteEmployee(@PathVariable Integer id) {
		employeeService.deleteEmployeeById(id);
	}
	@PutMapping("/putEmployee")
	public Employee putEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	@PostMapping("/addemployeDE")
	public List<Employee> addEmployeDE(@RequestBody List<Employee> employees) {
		// System.out.println(employee.getName() + "=====" + employee.getSalary() +
		// "=====" + employee.getDept());
		return employeeService.addEmployees(employees);
	}

	@PatchMapping("/patchEmployee/{id}")
	public Employee patchEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
		// Check if employee exists
		Employee existingEmployee = employeeService.getEmployeeById(id);
		if (existingEmployee == null) {
			throw new RuntimeException("Employee with ID " + id + " not found.");
		}

		// Update only non-null fields
		if (employee.getName() != null) {
			existingEmployee.setName(employee.getName());
		}
		if (employee.getSalary() != null) {
			existingEmployee.setSalary(employee.getSalary());
		}
		if (employee.getDept() != null) {
			existingEmployee.setDept(employee.getDept());
		}

		// Save updated employee
		return employeeService.updateEmployee(existingEmployee);
	}

}
