package com.segar.expensetrackerbackend.service;

import com.segar.expensetrackerbackend.model.User;
import com.segar.expensetrackerbackend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public User addUser(User user) {
        return repo.save(user);
    }
}
