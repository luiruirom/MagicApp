package es.sotero.magic.services;

import es.sotero.magic.dto.EmployeeDTO;
import es.sotero.magic.entities.Employee;
import es.sotero.magic.exception.ResourceNotFoundException;
import es.sotero.magic.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public Iterable<Employee> list() {
        return employeeRepository.findAll();
    }

    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Employee create(EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        return employeeRepository.save(employee);
    }

    public Employee update(Integer id, EmployeeDTO employeeDTO) {
        Employee employeeToUpdate = findById(id);
        modelMapper.map(employeeDTO, employeeToUpdate);

        return employeeRepository.save(employeeToUpdate);
    }

    public void delete(Integer id) {
        Employee employeeToDelete = findById(id);
        employeeRepository.delete(employeeToDelete);
    }
}
