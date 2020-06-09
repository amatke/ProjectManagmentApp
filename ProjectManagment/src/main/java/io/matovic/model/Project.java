package io.matovic.model;

import lombok.Data;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@Data
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String stage; // notstarted, completed, inprogres (enum)
	private String description;
	
	// ili mappedBy = "projects",
	@ManyToMany( cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
	@JoinTable(name="employee_project",
		joinColumns = @JoinColumn(name="project_id"),
		inverseJoinColumns = @JoinColumn(name="employee_id"))
	private List<Employee> employees;

	public Project() {}

	public Project(String name, String stage, String description) {
		this.name = name;
		this.stage = stage;
		this.description = description;
	}
}
