package es.sotero.magic.services;

import es.sotero.magic.auth.AuthResponse;
import es.sotero.magic.auth.LoginRequest;
import es.sotero.magic.auth.RegisterRequest;
import es.sotero.magic.entities.User;
import es.sotero.magic.repositories.UserRepository;
import es.sotero.magic.utils.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest loginRequest) {


            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            UserDetails user = userRepository.findByUsername(loginRequest.getUsername()).orElseThrow();
            String token = jwtService.getToken(user);
            return AuthResponse.builder()
                    .token(token)
                    .build();

    }

    public AuthResponse register(RegisterRequest registerRequest) {
        User user = User.of( registerRequest.getUsername(), passwordEncoder.encode(registerRequest.getPassword()) , registerRequest.getEmail(), registerRequest.getFirstName(), registerRequest.getLastName(), Role.ROLE_USER);

        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
