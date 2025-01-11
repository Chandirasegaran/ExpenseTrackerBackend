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

    public Object getExpenses() {
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



    public Expenses getExpenseByDate(Date date) {
        List<Expenses> expenses=repo.findAll();
        return expenses.stream().filter(t -> t.getDate().equals(date)).findFirst().orElse(new Expenses());
    }

    public Expenses getExpenseByMonth(Date date) {
        List<Expenses> expenses=repo.findAll();
        return expenses.stream().filter(t -> t.getDate().getMonth()==date.getMonth()).findFirst().orElse(new Expenses());
    }

}
