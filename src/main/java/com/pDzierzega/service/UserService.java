package com.pDzierzega.service;

import com.pDzierzega.DTO.NewUserDTO;
import com.pDzierzega.exceptions.authentication.UserAlreadyExistAuthenticationException;
import com.pDzierzega.model.AppUser;

import java.security.Principal;
import java.util.List;

public interface UserService {
    AppUser findUser(Principal principal);

    AppUser newUser(NewUserDTO newUser) throws UserAlreadyExistAuthenticationException;
    List<AppUser> getAll();
}
