package io.matovic.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import io.matovic.dto.ChartData;
import io.matovic.model.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>{
	
	@Query(nativeQuery = true,
			value="SELECT stage as label, count(*) as value " +
			"FROM PROJECT " +
			"group by stage")
	public Iterable<ChartData> projectStages();
}
