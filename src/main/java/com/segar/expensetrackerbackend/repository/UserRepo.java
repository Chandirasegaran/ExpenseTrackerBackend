package com.segar.expensetrackerbackend.repository;

import com.segar.expensetrackerbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo  extends JpaRepository<User, Integer> {

}
