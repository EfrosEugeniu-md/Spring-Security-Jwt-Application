package io.javabrains.springsecurityjwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewUserDTO {
    private String firstName;
    private String lastName;
    private String industry;
    private String initialAmount;
    private String username;
    private String password;
    private List<String> role;
}
