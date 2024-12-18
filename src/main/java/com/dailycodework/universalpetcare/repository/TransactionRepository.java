package com.dailycodework.universalpetcare.repository;

import com.dailycodework.universalpetcare.model.payment.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Transaction findFirstByOrderByIdDesc();

    List<Transaction> findAllByUser_Id(Long userID);

    Transaction findByTransNo(String transNo);
}
