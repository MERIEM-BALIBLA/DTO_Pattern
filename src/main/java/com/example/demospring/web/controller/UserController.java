package com.example.demospring.web.controller;

import com.example.demospring.domain.User;
import com.example.demospring.mapper.UserMapper;
import com.example.demospring.service.DTO.UserDTO;
import com.example.demospring.service.UserService;
import com.example.demospring.web.vm.UserVM;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public ResponseEntity<UserVM> createUser(@RequestBody UserVM userVM) {
        // Convert VM to DTO, pass to service, convert result back to VM
        UserDTO userDTO = userMapper.toDTO(userMapper.toEntityFromVM(userVM));
        UserDTO savedUserDTO = userService.save(userDTO);
        return ResponseEntity.ok(userMapper.toVM(userMapper.toEntity(savedUserDTO)));
    }

    @GetMapping
    public ResponseEntity<List<UserVM>> users() {
        List<User> usersList = userService.getAll();
        List<UserVM> userVMS = userMapper.toVMs(usersList);
        return ResponseEntity.ok(userVMS);
    }

}
