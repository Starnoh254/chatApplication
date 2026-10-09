package com.starnoh.chatapp.services;

import com.starnoh.chatapp.dto.LoginRequest;
import com.starnoh.chatapp.dto.LoginResponse;
import com.starnoh.chatapp.dto.RegisterRequest;
import com.starnoh.chatapp.dto.RegisterResponse;
import com.starnoh.chatapp.entities.User;
import com.starnoh.chatapp.exception.EmailAlreadyRegisteredException;
import com.starnoh.chatapp.exception.InvalidCredentialsException;
import com.starnoh.chatapp.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@AllArgsConstructor
public class UsersService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterResponse register(RegisterRequest request) {
        String email = request.email().trim();
        if (userRepository.existsByEmailIgnoreCase(email)) {
            throw new EmailAlreadyRegisteredException(email);
        }

        User user = new User();
        user.setFirstName(request.firstName().trim());
        user.setLastName(request.lastName().trim());
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(request.password()));

        User savedUser = userRepository.save(user);
        return new RegisterResponse(
                "Registration successful",
                savedUser.getFirstName(),
                savedUser.getLastName(),
                savedUser.getEmail()
        );
    }

    public LoginResponse login(LoginRequest request) {
        String email = request.email().trim();
        User user = userRepository.findByEmailIgnoreCase(email)
                .orElseThrow(InvalidCredentialsException::new);

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new InvalidCredentialsException();
        }

        return new LoginResponse(
                "Login successful",
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }

}
