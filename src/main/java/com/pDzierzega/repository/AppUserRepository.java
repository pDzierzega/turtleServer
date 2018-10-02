package com.pDzierzega.repository;

import com.pDzierzega.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppUserRepository extends JpaRepository<AppUser,String> {
    AppUser findOneByUsername(String username);

}
