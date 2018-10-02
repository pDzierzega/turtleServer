package com.pDzierzega.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewUserDTO {
    private String username;
    private String password;
    private String confirmedPassword;

}
