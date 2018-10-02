package com.pDzierzega.exceptions.authentication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserAlreadyExistAuthenticationException extends AuthenticationException {
    private String username;
}
