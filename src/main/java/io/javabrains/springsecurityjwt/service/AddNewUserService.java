package io.javabrains.springsecurityjwt.service;

import io.javabrains.springsecurityjwt.dto.NewUserDTO;
import io.javabrains.springsecurityjwt.dto.UserDTO;
import io.javabrains.springsecurityjwt.repository.SpringDataUserRepository;
import io.javabrains.springsecurityjwt.usecase.AddNewUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AddNewUserService implements AddNewUserUseCase {
    @Autowired
    SpringDataUserRepository userRepository;


    @Override
    public UserDTO create(NewUserDTO userDTO) {
        return userRepository.create(userDTO);

    }
}
