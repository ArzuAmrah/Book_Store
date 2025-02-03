package az.atl.bookstore.service.auth;

import az.atl.bookstore.dto.UserDto;
import az.atl.bookstore.entities.UserEntity;
import az.atl.bookstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Registers a new user.
     *
     * @param userDTO The user data transfer object containing registration details.
     */
    @Override
    public void register(UserDto userDTO) {
        // Check if the email is already registered
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already in use!");
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setFullName(userDTO.getFullName());

        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        userRepository.save(userEntity);
    }

    /**
     * Logs in a user.
     *
     * @param email    The user's email.
     * @param password The user's password.
     * @return The authenticated user entity.
     */
    @Override
    public UserEntity login(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(userEntity -> passwordEncoder.matches(password, userEntity.getPassword()))
                .orElseThrow(() -> new IllegalArgumentException("Email or Password is wrong"));
    }
}
