package io.matovic.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import io.matovic.dto.EmployeeProject;
import io.matovic.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

	@Query(nativeQuery = true, 
			value="SELECT e.FIRST_NAME AS firstName, e.LAST_NAME as lastName, COUNT(ep.EMPLOYEE_ID) as projectCount " +
			"FROM EMPLOYEE e LEFT JOIN EMPLOYEE_PROJECT ep ON e.ID = ep.EMPLOYEE_ID " +
			"GROUP BY e.FIRST_NAME, e.LAST_NAME order by 3 desc")
	public Iterable<EmployeeProject> employeeProjects();
}
