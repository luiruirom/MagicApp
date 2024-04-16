package es.sotero.magic;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import es.sotero.magic.entities.Employee;
import es.sotero.magic.repositories.EmployeeRepository;

@SpringBootApplication
public class MagicApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagicApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(EmployeeRepository employeeRepository) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				List<Employee> employees = Arrays.asList(
                        new Employee("John", "Doe"),
                        new Employee("Jane", "Doe"),
                        new Employee("Tom", "Doe")
                        );
			employeeRepository.saveAll(employees);
			}
		};
	}
}
