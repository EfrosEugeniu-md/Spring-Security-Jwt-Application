package io.javabrains.springsecurityjwt.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewUserRoleDTO {
    private Long userId;
    private String name;
}
