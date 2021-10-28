package io.javabrains.springsecurityjwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String industry;
    private String initialAmount;
    private String username;
    private String password;

    public UserDTO(int i,NewUserDTO newUserDTO){
        this.id=Long.parseLong(String.valueOf(i)) ;
        this.firstName=newUserDTO.getFirstName();
        this.lastName=newUserDTO.getLastName();
        this.industry=newUserDTO.getIndustry();
        this.username=newUserDTO.getUsername();
        this.password=newUserDTO.getPassword();

    }
}
