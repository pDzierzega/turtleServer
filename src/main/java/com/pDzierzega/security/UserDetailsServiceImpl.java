package com.pDzierzega.security;

import com.pDzierzega.model.AppUser;
import com.pDzierzega.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private AppUserRepository repository;

    @Autowired
    public UserDetailsServiceImpl(AppUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser =repository.findOneByUsername(username);

        if (appUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User (appUser.getUsername(), appUser.getPassword(), Collections.emptyList());
    }
}
