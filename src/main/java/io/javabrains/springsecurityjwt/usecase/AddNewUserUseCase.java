package io.javabrains.springsecurityjwt.usecase;

import io.javabrains.springsecurityjwt.dto.NewUserDTO;
import io.javabrains.springsecurityjwt.dto.UserDTO;

public interface AddNewUserUseCase {
    UserDTO create(NewUserDTO userDTO);
}
