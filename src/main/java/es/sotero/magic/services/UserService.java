package es.sotero.magic.services;

import es.sotero.magic.dto.UserDTO;
import es.sotero.magic.entities.User;
import es.sotero.magic.exception.ResourceNotFoundException;
import es.sotero.magic.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public Iterable<User> list() {
        return userRepository.findAll();
    }

    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(ResourceNotFoundException::new);
    }

    public User create(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        return userRepository.save(user);
    }

    public User update(Integer id, UserDTO userDTO) {
        User userToUpdate = findById(id);
        modelMapper.map(userDTO, userToUpdate);

        return userRepository.save(userToUpdate);
    }

    public void delete(Integer id) {
        User userToDelete = findById(id);
        userRepository.delete(userToDelete);
    }

    public String isAdmin(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(ResourceNotFoundException::new);
        return user.getRole().toString();
    }
}
