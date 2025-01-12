package com.segar.expensetrackerbackend.service;

import com.segar.expensetrackerbackend.model.Expenses;
import com.segar.expensetrackerbackend.repository.ExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExpenseService {

@Autowired
    private ExpenseRepo repo;

    public Expenses addExpense(Expenses expenses) {
        return repo.save(expenses);
    }

    public Expenses getExpense(int id) {
        List<Expenses> expenses=repo.findAll();
        return expenses.stream().filter(t -> t.getId()==(id)).findFirst().orElse(new Expenses());
    }

    public List<Expenses> getAllExpenses() {
        return repo.findAll();
    }


    public void deleteExpense(int id) {
        repo.deleteById(id);
    }

    public Expenses updateExpense(int id, Expenses expenses) {

        Expenses expenses1 = repo.findById(id).get();
        if(expenses1 == null) {
            return null;
        }
        return repo.save(expenses);
    }

    public List<Expenses> getExpensesByEmail(String email) {
        return repo.findByUserEmail(email);
    }

    public List<Expenses> getExpenseByDate(Date date) {
        System.out.println(date);
        System.out.println(repo.findByDate(date));
        return repo.findByDate(date);
    }

    public List<Expenses> getExpensesByDateAndEmail(Date date, String email) {
        return repo.findByDateAndUserEmail(date, email);
    }

    public List<Expenses> getExpensesByMonthAndEmail(int month, int year, String email) {
        return repo.findByMonthAndYearAndUserEmail(month, year, email);
    }
}
