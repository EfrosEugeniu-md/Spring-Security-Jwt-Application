package io.javabrains.springsecurityjwt.repository;

import io.javabrains.springsecurityjwt.dto.NewUserDTO;
import io.javabrains.springsecurityjwt.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public class SpringDataUserRepositoryImpl implements SpringDataUserRepository {
    private List<UserDTO> userDTOList;

    static public int indexNext=6;

    public SpringDataUserRepositoryImpl() {
        this.userDTOList = new ArrayList<>();

        userDTOList.add(new UserDTO(1L, "asdfcv", "jduyts",
                "ghfdh", "fdgsh", "foo", "foo", new ArrayList<>(
                Arrays.asList("USER"))));

        userDTOList.add(new UserDTO(2L, "asdfcv", "jduyts",
                "ghfdh", "fdgsh", "foo1", "foo1", new ArrayList<>(
                Arrays.asList("ADMIN"))));

    }

    @Override
    public UserDTO create(NewUserDTO newUserDTO) {
        UserDTO userDTO1=new UserDTO(indexNext++,newUserDTO);
        userDTOList.add(userDTO1);
        return userDTO1;
    }

    @Override
    public Optional<UserDTO> findByUsername(String s) {
        for (UserDTO userDTO : userDTOList) {
            if (userDTO.getUsername().equals(s)) return Optional.of(userDTO);
        }
        return Optional.empty();
    }

    @Override
    public Collection<UserDTO> findAll() {
        return userDTOList;
    }
}
