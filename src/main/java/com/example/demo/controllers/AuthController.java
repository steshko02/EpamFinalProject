package com.example.demo.controllers;

import com.example.demo.httpsessionService.SessionService;
import com.example.demo.model.Customer;
import com.example.demo.model.Passport;
import com.example.demo.model.domain.User;
import com.example.demo.servicies.CustomerService;
import com.example.demo.servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerService customerService;
    @Autowired
    private SessionService sessionService;


    @RequestMapping("/auth/login")
    public String getLoginPage() {
//        if(sessionService.getUserState()) {
//            SecurityContextHolder.getContext().setAuthentication((Authentication) sessionService.getCurrentUserAuthentication());
//        }
        return "login";
    }

    @GetMapping("/auth/AutWarning")
    public String redirect() {
        return "AutWarning";
    }

    @GetMapping("/auth/success")
    public String getSuccessPage() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String username = auth.getName();
        return "welcome";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid User userForm,
                          BindingResult bindingResult, Model model) {

        userService.addNewUser(userForm);

        return "redirect:/auth/login";
    }
}