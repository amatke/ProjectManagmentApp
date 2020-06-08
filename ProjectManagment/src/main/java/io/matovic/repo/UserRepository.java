package io.matovic.repo;

import io.matovic.dto.ChartData;
import io.matovic.model.Project;
import io.matovic.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{

	User findByUsername(String username);
}
