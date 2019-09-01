package pl.rengreen.taskmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    String showLoginForm() {
        //login form is submitted using POST method <form th:action="@{/login}" method="post">
        return "forms/login";
    }
}
