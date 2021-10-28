package io.javabrains.springsecurityjwt.repository;

import io.javabrains.springsecurityjwt.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class SpringDataUserRepositoryImpl implements SpringDataUserRepository{
    private List<UserDTO> userDTOList;
    public SpringDataUserRepositoryImpl(){
        this.userDTOList=new ArrayList<>();

        userDTOList.add(new UserDTO(1L,"asdfcv","jduyts",
                "ghfdh","fdgsh","foo","foo"));

        userDTOList.add(new UserDTO(2L,"asdfcv","jduyts",
                "ghfdh","fdgsh","foo1","foo1"));

    }
    @Override
    public Optional<UserDTO> findByUsername(String s) {
        for(UserDTO userDTO:userDTOList){
            if (userDTO.getUsername().equals(s)) return Optional.of(userDTO);
        }
        return Optional.empty();
    }
}
