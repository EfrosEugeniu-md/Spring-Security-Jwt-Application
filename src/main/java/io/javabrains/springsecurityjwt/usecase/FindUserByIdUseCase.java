package io.javabrains.springsecurityjwt.usecase;

import io.javabrains.springsecurityjwt.dto.UserDTO;

public interface FindUserByIdUseCase {
    UserDTO findById(Long id);
}
