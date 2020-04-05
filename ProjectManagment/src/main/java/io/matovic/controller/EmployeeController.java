package io.matovic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.matovic.model.Employee;
import io.matovic.repo.EmployeeRepository;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping
	public String displayEmployees(Model model) {
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();
		model.addAttribute("employees", employees);
		return "employee/list-employees";		//new-employee.html
	}
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employee/new-employee";		//new-employee.html
	}
	
	
	@PostMapping("/save")
	public String saveEmployee(Employee employee, Model model) {
		employeeRepository.save(employee);
		
		//use a redirect to prevent duplicate submissions
		return "redirect:/employees";		
	}
}
