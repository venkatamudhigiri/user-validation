package com.user.service;

import java.util.List;

import com.user.entity.Transactions;

public interface TransactionsService {

	List<Transactions> getTransactionsByUserName(String userName);
	
	void save(Transactions transaction);
}
