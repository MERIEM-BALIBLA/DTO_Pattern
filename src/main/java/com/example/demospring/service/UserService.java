package com.example.demospring.service;

import com.example.demospring.domain.User;
import com.example.demospring.service.DTO.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface UserService {

    List<User> getAll();

    UserDTO save(UserDTO user);

    User update(User user);

    void delete(User user);


}
