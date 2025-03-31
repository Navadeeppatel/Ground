package com.example.differentmodules.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.differentmodules.dto.Employee;
import com.example.differentmodules.repo.EmpExpRepo;

@Service

public class EmployeeService {

	@Autowired

	private EmpExpRepo employeerepo;

	public Employee addEmployee(Employee employee) {
		return employeerepo.save(employee);
	}

	public List<com.example.differentmodules.dto.Employee> getAllEmployees() {

		return employeerepo.findAll();

	}

	public void deleteEmployeeById(Integer id) {
		try {
			employeerepo.deleteById(id);
			System.out.println("Employee deleted: " + id);
		} catch (Exception e) {
			System.out.println("Not able to delete employee");
		}

	}

	public Employee getEmployeeById(Integer id) {
		return employeerepo.findById(id).orElse(null);
	}

	public Employee updateEmployee(Employee employee) {
		return employeerepo.save(employee);
	}

	public List<Employee> addEmployees(List<Employee> employees) {
		return employeerepo.saveAll(employees);
	}

	public Employee findById(Integer id, Double salary) {
		List<Employee> emplist1 = new ArrayList<>();

		Employee e = new Employee();
		e.setId(1);
		e.setName("swetha");
		e.setSalary(1000.00);
		Employee e1 = new Employee();
		e1.setId(2);
		e1.setName("dsfds");
		e1.setSalary(2000.00);
		Employee e2 = new Employee();
		e2.setId(3);
		e2.setName("efn2");
		e2.setSalary(3000.00);
		emplist1.add(e);
		emplist1.add(e1);
		emplist1.add(e2);
		emplist1.sort(Comparator.comparing(Employee::getName));
		for (Employee employee : emplist1) {
			if (id == null && employee.getSalary().equals(salary)) {
				return employee;

			}

			else {
				if (employee.getId().equals(id) && employee.getSalary().equals(salary)) {

					return employee;
				}
			}

		}
		return new Employee();

	}

}
