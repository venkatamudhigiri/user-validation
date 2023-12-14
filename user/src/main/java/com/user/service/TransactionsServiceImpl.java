package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.Transactions;
import com.user.repository.TransactionsRespository;

@Service
public class TransactionsServiceImpl implements TransactionsService {

	@Autowired
	TransactionsRespository transactionsRespository;

	public List<Transactions> getTransactionsByUserName(String userName) {
		return transactionsRespository.findByUsername(userName);

	}
	
	public void save(Transactions transaction) {
		transactionsRespository.save(transaction);
	}
}
