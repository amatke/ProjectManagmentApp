package io.matovic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import io.matovic.model.Employee;
import io.matovic.model.Project;
import io.matovic.repo.EmployeeRepository;
import io.matovic.repo.ProjectRepository;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects = (List<Project>) projectRepository.findAll();
		model.addAttribute("projects", projects);
		return "project/list-projects";		//new-project.html
	}
	
	@GetMapping("/new")
	public String displayProjectForm(@ModelAttribute Project project, Model model) {
		//Project project = new Project();
		//model.addAttribute("project", project);
		
		model.addAttribute("allEmployees", employeeRepository.findAll());
		return "project/new-project";		//new-project.html
	}
	
	
	@PostMapping("/save")
	public String saveProject(Project project, Model model) {
		
		projectRepository.save(project);
				
		//use a redirect to prevent duplicate submissions
		return "redirect:/projects";		
	}
}
