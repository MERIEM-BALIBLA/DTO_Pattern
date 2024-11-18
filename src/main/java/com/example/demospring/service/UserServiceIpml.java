package com.example.demospring.service;

import com.example.demospring.domain.User;
import com.example.demospring.mapper.UserMapper;
import com.example.demospring.repo.UserRepository;
import com.example.demospring.service.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceIpml implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceIpml(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        // Convert DTO to entity and save
        User user = userMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        // Convert saved entity back to DTO
        return userMapper.toDTO(savedUser);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}
