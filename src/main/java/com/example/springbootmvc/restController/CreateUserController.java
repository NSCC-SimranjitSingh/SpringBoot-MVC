package com.example.springbootmvc.restController;

import com.example.springbootmvc.model.User;
import com.example.springbootmvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CreateUserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user){

        User newUser = userRepository.save(new User(user.getName()));

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllPersons(){

        List<User> users = new ArrayList<User>();

        userRepository.findAll().forEach(users::add);

        return new ResponseEntity<>(users, HttpStatus.OK);

    }
}
