package az.atl.bookshop.service;

import az.atl.bookshop.dto.UserDTO;
import az.atl.bookshop.entities.UserEntity;
import az.atl.bookshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void register(UserDTO userDTO) {
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already in use!");
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setFullName(userDTO.getFullName());
        userEntity.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        userRepository.save(userEntity);
    }

    public UserEntity login(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(userEntity -> bCryptPasswordEncoder.matches(password, userEntity.getPassword()))
                .orElseThrow(() -> new IllegalArgumentException("Email or Password is wrong"));
    }
}
