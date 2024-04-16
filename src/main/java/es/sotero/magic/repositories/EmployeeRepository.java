package es.sotero.magic.repositories;

import org.springframework.data.repository.CrudRepository;

import es.sotero.magic.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	
}
