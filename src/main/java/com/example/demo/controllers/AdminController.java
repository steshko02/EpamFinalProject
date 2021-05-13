package com.example.demo.controllers;

import com.example.demo.httpsessionService.SessionService;
import com.example.demo.servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('users:write') && hasAuthority('users:read')")
    public String index(Model model){
        model.addAttribute("users",userService.allUsers());

        SessionService sessionService = new SessionService();
        sessionService.getCurrentUserAuthentication();

        return "user_info";
    }
    @GetMapping("/users/{id}")
    @PreAuthorize("hasAuthority('users:write') && hasAuthority('users:read')")
    public String userInfo(@PathVariable("id") Long id,Model model){
        model.addAttribute("user",userService.findUserById(id));
        return "user";
    }
}
