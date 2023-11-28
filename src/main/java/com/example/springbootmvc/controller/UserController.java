package com.example.springbootmvc.controller;

import com.example.springbootmvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/getUser")
    public String user(Model model){

        model.addAttribute("users", userRepository.findAll());
        return "user";
    }

}
