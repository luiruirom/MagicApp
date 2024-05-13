package es.sotero.magic.services;

import es.sotero.magic.dto.ComputerDTO;
import es.sotero.magic.entities.Computer;
import es.sotero.magic.exception.ResourceNotFoundException;
import es.sotero.magic.repositories.ComputerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class ComputerService {

    private final ComputerRepository computerRepository;
    private final ModelMapper modelMapper;

    public Iterable<Computer> list() {
        return computerRepository.findAll();
    }

    public Computer findById(Integer id) {
        return computerRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Computer create(ComputerDTO computerDTO) {
        Computer computer = modelMapper.map(computerDTO, Computer.class);
        return computerRepository.save(computer);
    }

    public Computer update(Integer id, ComputerDTO computerDTO) {
        Computer employeeToUpdate = findById(id);
        modelMapper.map(computerDTO, employeeToUpdate);

        return computerRepository.save(employeeToUpdate);
    }

    public void delete(Integer id) {
        Computer computerToDelete = findById(id);
        computerRepository.delete(computerToDelete);
    }
}
