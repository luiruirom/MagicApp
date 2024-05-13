package es.sotero.magic.repositories;

import es.sotero.magic.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer>{
	Optional<User> findByUsername(String username);
}
