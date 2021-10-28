package io.javabrains.springsecurityjwt.security;

import io.javabrains.springsecurityjwt.dto.UserDTO;
import io.javabrains.springsecurityjwt.dto.UserDtoDetails;
import io.javabrains.springsecurityjwt.repository.SpringDataUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    SpringDataUserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDTO> userDTO = userRepository.findByUsername(username);

        userDTO.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

        return userDTO.map(UserDtoDetails::new).get();
    }
}