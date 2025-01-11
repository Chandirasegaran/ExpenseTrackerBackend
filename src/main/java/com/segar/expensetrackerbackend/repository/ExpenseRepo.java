package com.segar.expensetrackerbackend.repository;

import com.segar.expensetrackerbackend.model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepo extends JpaRepository<Expenses, Integer> {

}
