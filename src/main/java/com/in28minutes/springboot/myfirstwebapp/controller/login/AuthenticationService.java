package com.in28minutes.springboot.myfirstwebapp.controller.login;

import org.springframework.stereotype.Service;

/**
 * Created By dhhaval thakkar on 2023-10-26
 */
@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password) {

        boolean isValidUsername = username.equalsIgnoreCase("name");
        boolean isValidPassword = password.equalsIgnoreCase("password");

        return isValidUsername && isValidPassword;
    }
}
