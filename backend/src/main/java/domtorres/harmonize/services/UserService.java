package domtorres.harmonize.services;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domtorres.harmonize.models.User;
import domtorres.harmonize.repositories.UserRepository;
import domtorres.harmonize.requests.CreateUserRequest;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder; 
    }

    public User createUser(CreateUserRequest request) {
        User user = new User();

        user.setUsername(request.getUsername());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setRoles("user");
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);

        return user;
    }

    @Transactional
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}

