package com.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.Transactions;

public interface TransactionsRespository extends JpaRepository<Transactions, Long> {
	List<Transactions> findByUsername(String username);
}
