package com.segar.expensetrackerbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/expense")
@RestController
public class ExpenseController {

    @GetMapping("/")
    public String index() {
        return "Hello World! You are Successfully up and Running Expense Tracker Backend";
    }
}
