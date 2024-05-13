package es.sotero.magic.repositories;

import es.sotero.magic.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	
}
