package com.pDzierzega.controller;

import com.pDzierzega.DTO.NewUserDTO;
import com.pDzierzega.DTO.UserDTO;
import com.pDzierzega.mapper.UserMapper;
import com.pDzierzega.model.AppUser;
import com.pDzierzega.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private UserService service;
    private UserMapper mapper;

    @Autowired
    public UserController(UserService service, UserMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/sign-up")
    public UserDTO newUser (@RequestBody NewUserDTO userDTO) {
        AppUser user = service.newUser(userDTO);
        return mapper.toUserDto(user);
    }

    @GetMapping
    public UserDTO getLogged (Principal principal){
        AppUser user = service.findUser(principal);
        return mapper.toUserDto(user);
    }

    @GetMapping("/all")
    public List<UserDTO> getAll(){
        List<AppUser> userList = service.getAll();
        return mapper.toUserDto(userList);
    }
}
