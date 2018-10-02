package com.pDzierzega.service.impl;

import com.pDzierzega.DTO.NewUserDTO;
import com.pDzierzega.exceptions.authentication.UserAlreadyExistAuthenticationException;
import com.pDzierzega.model.AppUser;
import com.pDzierzega.repository.AppUserRepository;
import com.pDzierzega.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private AppUserRepository repository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(AppUserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AppUser newUser(NewUserDTO newUser) {
        AppUser appUser;
        System.out.println(newUser);

        if (newUser.getPassword().equals(newUser.getConfirmedPassword())){
            appUser =new AppUser();
            appUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
            appUser.setUsername(newUser.getUsername());
            return repository.save(appUser);
        }

        return null;
    }

    @Override
    public AppUser findUser(Principal principal) {
        return repository.findOneByUsername(principal.getName());
    }

    @Override
    public List<AppUser> getAll() {
       return repository.findAll();
    }
}
