package es.sotero.magic.controllers;

import es.sotero.magic.dto.EmployeeDTO;
import es.sotero.magic.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import es.sotero.magic.entities.Employee;

@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/employee")
@RestController
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping
    public Iterable<Employee> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public Employee get(@PathVariable Integer id) {
        return service.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Employee create(@Validated @RequestBody EmployeeDTO employeeDTO) {
        return service.create(employeeDTO);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Integer id,
                           @Validated @RequestBody EmployeeDTO employeeDTO) {
        return service.update(id, employeeDTO);

    }

	@ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
