package com.segar.expensetrackerbackend.repository;

import com.segar.expensetrackerbackend.model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ExpenseRepo extends JpaRepository<Expenses, Integer> {
    List<Expenses> findByUserEmail(String email);

    @Query(value = "SELECT * FROM expenses WHERE DATE(date) = :date", nativeQuery = true)
    List<Expenses> findByDate(Date date);

    @Query(value = "SELECT * FROM expenses WHERE DATE(date) = :date AND user_email = :email", nativeQuery = true)
    List<Expenses> findByDateAndUserEmail(@Param("date") Date date, @Param("email") String email);

    @Query(value = "SELECT * FROM expenses WHERE MONTH(date) = :month AND YEAR(date) = :year AND user_email = :email", nativeQuery = true)
    List<Expenses> findByMonthAndYearAndUserEmail(int month, int year, String email);
}
