package az.atl.bookstore.service.auth;


import az.atl.bookstore.dto.UserDto;
import az.atl.bookstore.entities.UserEntity;

public interface AuthService {

    void register(UserDto userDto);

    UserEntity login(String email, String password);
}

