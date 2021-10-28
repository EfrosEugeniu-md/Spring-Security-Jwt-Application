package io.javabrains.springsecurityjwt.usecase;

import io.javabrains.springsecurityjwt.dto.UserDTO;

import java.util.Collection;

public interface FindAllUsersUseCase {
    Collection<UserDTO> findAll();
}
