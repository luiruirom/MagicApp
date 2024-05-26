package es.sotero.magic.repositories;

import es.sotero.magic.entities.ComputerSession;
import org.springframework.data.repository.CrudRepository;

public interface SessionRepository extends CrudRepository<ComputerSession, Integer> {

}
