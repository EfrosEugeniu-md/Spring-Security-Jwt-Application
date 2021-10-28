package io.javabrains.springsecurityjwt.security;

import io.javabrains.springsecurityjwt.dto.UserDTO;
import io.javabrains.springsecurityjwt.repository.SpringDataUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    SpringDataUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
       UserDTO userDTO =  userRepository.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + s));
        return new User(userDTO.getUsername(), userDTO.getPassword(),
                new ArrayList<>());
    }
}