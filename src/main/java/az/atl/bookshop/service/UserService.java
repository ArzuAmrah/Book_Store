package az.atl.bookshop.service;

import az.atl.bookshop.entities.UserEntity;
import az.atl.bookshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public UserEntity getUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found!"));
    }

    public UserEntity updateUser(Long id, UserEntity updatedUser) {
        UserEntity user = getUserById(id);
        user.setFullName(updatedUser.getFullName());
        user.setEmail(updatedUser.getEmail());
        return userRepository.save(user);
    }
}
