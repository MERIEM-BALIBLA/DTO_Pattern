package com.example.demospring.mapper;

import com.example.demospring.domain.User;
import com.example.demospring.service.DTO.UserDTO;
import com.example.demospring.web.vm.UserVM;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // Maps User (Entity) to UserDTO
    UserDTO toDTO(User user);

    // Maps UserDTO to User (Entity) for saving/updating
    User toEntity(UserDTO userDTO);

    // Maps User (Entity) to UserVM for display
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    UserVM toVM(User user);

    // Maps UserVM to User (Entity) for input
    User toEntityFromVM(UserVM userVM);

    List<UserVM> toVMs(List<User> users);
}
