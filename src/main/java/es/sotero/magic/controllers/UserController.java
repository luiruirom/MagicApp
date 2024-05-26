package es.sotero.magic.controllers;

import es.sotero.magic.dto.UserDTO;
import es.sotero.magic.entities.User;
import es.sotero.magic.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/user")
@RestController
public class UserController {

    private final UserService service;

    @GetMapping
    public Iterable<User> list() {
        return service.list();
    }

    @GetMapping("/{username}")
    public User get(@PathVariable String username) {
        return service.findByUsername(username);
    }

    @GetMapping("/isAdmin/{username}")
    public String isAdmin(@PathVariable String username) { return service.isAdmin(username); }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public User create(@Validated @RequestBody UserDTO userDTO) {
        return service.create(userDTO);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Integer id,
                           @Validated @RequestBody UserDTO userDTO) {
        return service.update(id, userDTO);

    }

	@ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
