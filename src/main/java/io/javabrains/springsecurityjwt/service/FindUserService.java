package io.javabrains.springsecurityjwt.service;


import io.javabrains.springsecurityjwt.dto.UserDTO;
import io.javabrains.springsecurityjwt.repository.SpringDataUserRepository;
import io.javabrains.springsecurityjwt.usecase.FindAllUsersUseCase;
import io.javabrains.springsecurityjwt.usecase.FindUserByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FindUserService implements FindUserByIdUseCase, FindAllUsersUseCase {
    @Autowired
    SpringDataUserRepository userRepository;
    @Override
    public Collection<UserDTO> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserDTO findById(Long id) {
        return null;
    }
}
