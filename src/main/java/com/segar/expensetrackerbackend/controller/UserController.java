package com.segar.expensetrackerbackend.controller;

import com.segar.expensetrackerbackend.model.User;
import com.segar.expensetrackerbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


@RestController
@CrossOrigin
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public ResponseEntity<String> greet() {
        return new ResponseEntity<>("Hello World! You are Successfully up and Running Expense Tracker Backend\nThis is User Module", HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user){
      try {
          User user1 = userService.addUser(user);
          return new ResponseEntity<>(user1, HttpStatus.CREATED);
      }
      catch (Exception e){
          return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }


}
