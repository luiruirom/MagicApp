package es.sotero.magic.services;

import es.sotero.magic.entities.ComputerSession;
import es.sotero.magic.repositories.SessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@AllArgsConstructor
@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    public void createSession(String computerName) {
        LocalTime startTime = LocalTime.of(17, 0);
        for (int i = 0; i < 5; i++) {
            ComputerSession newComputerSession = new ComputerSession();
            newComputerSession.setComputerName(computerName);
            newComputerSession.setStartTime(startTime);
            newComputerSession.setEndTime(startTime.plusHours(1));
            newComputerSession.setSessionReserved(false);
            sessionRepository.save(newComputerSession);
            startTime = startTime.plusHours(1);
        }
    }

    public void delete(String computerName){
        for(ComputerSession computerSession : sessionRepository.findAll()){
            if(computerSession.getComputerName().equals(computerName)){
                sessionRepository.delete(computerSession);
            }
        }
    }
}
