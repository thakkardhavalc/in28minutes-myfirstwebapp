package com.in28minutes.springboot.myfirstwebapp.controller.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created By dhhaval thakkar on 2023-10-25
 */
@Controller
public class SayHelloController {

    @GetMapping("say-hello")
    @ResponseBody
    public String sayHello() {
        return "Hello! What are you learning today?";
    }

    @GetMapping("say-hello-jsp")
    public String sayHelloHtml() {
        return "sayHello";
    }
}
