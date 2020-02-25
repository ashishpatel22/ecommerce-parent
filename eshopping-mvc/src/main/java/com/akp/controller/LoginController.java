package com.akp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;

/**
 * @author Aashish Patel
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Principal principal, HttpSession session) {
        if (principal != null) {

            return "redirect:/home";
        }
        return "/login";
    }
}
