package io.javabrains.springsecurityjwt.repository;

import io.javabrains.springsecurityjwt.dto.UserDTO;

import java.util.Optional;

public interface SpringDataUserRepository   {

    Optional<UserDTO> findByUsername(String s);
}
