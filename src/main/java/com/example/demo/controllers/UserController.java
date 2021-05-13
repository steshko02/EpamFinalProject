package com.example.demo.controllers;

import com.example.demo.model.Customer;
import com.example.demo.model.Passport;
import com.example.demo.model.domain.User;
import com.example.demo.servicies.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/hotel")
public class UserController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/home")
    public String registration(){
        return "home";
    }

    @GetMapping("/create")
    public String registration(Model model) {
        model.addAttribute("customer", new Customer());

        return "customer_info";
    }

    @PostMapping("/create")
    public String addUser(@ModelAttribute("customer") @Valid Customer customer,
                          BindingResult bindingResult, Model model) {

        customerService.addNewCustomer(customer);

        return "redirect:/";
    }
}