package az.atl.bookshop.dto;


import lombok.Data;

@Data
public class UserDTO {

    private String email;
    private String password;
    private String fullName;
}