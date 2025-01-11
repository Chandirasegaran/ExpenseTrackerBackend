package com.segar.expensetrackerbackend.controller;

import com.segar.expensetrackerbackend.model.Expenses;
import com.segar.expensetrackerbackend.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequestMapping("api/expense")
@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/")
    public String index() {
        return "Hello World! You are Successfully up and Running Expense Tracker Backend";
    }

    @PostMapping("/addExpense")
    public ResponseEntity<?> addExpense(@RequestBody Expenses expenses) {
        Expenses expenses1 = expenseService.addExpense(expenses);
        return ResponseEntity.ok(expenses1);

    }

    @GetMapping("/getExpense/{id}")
    public ResponseEntity<?> getExpense(@PathVariable("id") Integer id) {
        Expenses expenses = expenseService.getExpense(id);
        if(expenses.getItemName() == null) {
            return new ResponseEntity<>("No Expense Found", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(expenses);
    }

    @GetMapping("/getExpenses")
    public ResponseEntity<?> getExpenses() {
        Expenses expenses = (Expenses) expenseService.getExpenses();
        if(expenses == null) {
            return new ResponseEntity<>("No Expense Found", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(expenses);
    }

    @DeleteMapping("/deleteExpense/{id}")
    public ResponseEntity<?> deleteExpense(@PathVariable("id") int id) {
        Expenses expenses = expenseService.getExpense(id);
        if(expenses.getItemName() == null) {
            return new ResponseEntity<>("No Expense Found", HttpStatus.NOT_FOUND);
        }
        expenseService.deleteExpense(id);
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @PutMapping("/updateExpense/{id}")
    public ResponseEntity<?> updateExpense(@PathVariable int id, @RequestBody Expenses expenses) {
        Expenses expenses1 = expenseService.getExpense(expenses.getId());
        if(expenses1 == null) {
            return new ResponseEntity<>("No Expense Found", HttpStatus.NOT_FOUND);
        }
        Expenses expenses2 = expenseService.updateExpense(id,expenses);

        return ResponseEntity.ok(expenses2);
    }

    @GetMapping("/getExpensebyDate/{date}")
    public ResponseEntity<?> getExpenseByDate(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        Expenses expenses = expenseService.getExpenseByDate(date);
        if(expenses.getItemName() == null) {
            return new ResponseEntity<>("No Expense Found", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(expenses);
    }

    @GetMapping("/getExpensebyMonth/{month}")
    public ResponseEntity<?> getExpenseByMonth(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd" ) Date date) {
        Expenses expenses = expenseService.getExpenseByMonth(date);
        if(expenses.getItemName() == null) {
            return new ResponseEntity<>("No Expense Found", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(expenses);
    }

}
