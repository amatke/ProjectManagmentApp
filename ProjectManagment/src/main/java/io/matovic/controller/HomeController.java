package io.matovic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.matovic.dto.ChartData;
import io.matovic.repo.EmployeeRepository;
import io.matovic.repo.ProjectRepository;

@Controller
public class HomeController {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Value("${version}")
	private String version;
	
	@GetMapping("/")
	public String displayIndexPage(Model model) throws JsonProcessingException {
		
		model.addAttribute("version", version);
		
		model.addAttribute("projects", projectRepository.findAll());
		//model.addAttribute("employees", employeeRepository.findAll());
		
		//List<ChartData> ls = projectRepository.projectStages();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectRepository.projectStages());
		model.addAttribute("projectsStage", jsonString);

		model.addAttribute("employeesListProjectCnt", employeeRepository.employeeProjects());
		
		return "main/index";		
	}
}
