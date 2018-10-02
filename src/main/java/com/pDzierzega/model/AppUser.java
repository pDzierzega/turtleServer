package com.pDzierzega.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class AppUser extends BaseEntity {
    private String username;
    private String password;
}
