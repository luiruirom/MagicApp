package es.sotero.magic.controllers;

import es.sotero.magic.dto.ComputerDTO;
import es.sotero.magic.entities.Computer;
import es.sotero.magic.services.ComputerService;
import es.sotero.magic.services.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/computer")
@RestController
public class ComputerController {

    private final ComputerService service;
    private final SessionService sessionService;

    @GetMapping
    public Iterable<Computer> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public Computer get(@PathVariable Integer id) {
        return service.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Computer create(@Validated @RequestBody ComputerDTO computerDTO) {
        sessionService.createSession(computerDTO.getName());
        return service.create(computerDTO);
    }

    @PutMapping("/{id}")
    public Computer update(@PathVariable Integer id,
                           @Validated @RequestBody ComputerDTO computerDTO) {
        return service.update(id, computerDTO);

    }

	@ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        sessionService.delete(service.findById(id).getName());
        service.delete(id);
    }
}
