package io.javabrains.springsecurityjwt.repository;

import io.javabrains.springsecurityjwt.dto.NewUserDTO;
import io.javabrains.springsecurityjwt.dto.UserDTO;

import java.util.Collection;
import java.util.Optional;

public interface SpringDataUserRepository {
    UserDTO create(NewUserDTO userDTO);

    Optional<UserDTO> findByUsername(String s);

    Collection<UserDTO> findAll();

}
