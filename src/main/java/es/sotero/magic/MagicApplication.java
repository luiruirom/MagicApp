package es.sotero.magic;

import es.sotero.magic.entities.Employee;
import es.sotero.magic.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

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
					Employee.of("John Doe", "1"),
					Employee.of("John Doe", "2"),
					Employee.of("John Doe", "3")
				);
				employeeRepository.saveAll(employees);

			}
		};
	}

	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
