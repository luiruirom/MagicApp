package es.sotero.magic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.sotero.magic.entities.Employee;
import es.sotero.magic.repositories.EmployeeRepository;

@RequestMapping("/api/employee")
@RestController
public class EmployeeController {	
	
	 @Autowired
	 private EmployeeRepository employeeRepository;
	 
	 @GetMapping
	 Iterable<Employee> list() {
		 return employeeRepository.findAll();
	 }
}
