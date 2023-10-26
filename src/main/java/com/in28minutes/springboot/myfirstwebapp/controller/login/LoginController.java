package com.in28minutes.springboot.myfirstwebapp.controller.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created By dhhaval thakkar on 2023-10-25
 */
@Slf4j
@Controller
public class LoginController {

    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("login")
    public String gotoLoginPage() {
        return "login";
    }

    @PostMapping("login")
    public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {

        if (authenticationService.authenticate(name, password)) {
            model.put("name", name);

            return "welcome";
        }
        model.put("errorMessage", "Invalid Credentials! Please try again");
        return "login";
    }
}
