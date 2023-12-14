package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.Transactions;
import com.user.exception.InvalidTokenException;
import com.user.exception.TransactionsNotFoundException;
import com.user.service.TransactionsServiceImpl;
import com.user.uitil.JwtTokenUtil;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/transactions")
public class TransactionsController {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	TransactionsServiceImpl transactionsService;

	@PostMapping("/save")
	public ResponseEntity<Object> saveTransaction(@RequestBody Transactions transaction) {
		transactionsService.save(transaction);
		return ResponseEntity.ok("Transaction Saved Successfully");
	}

	@GetMapping()
	public ResponseEntity<Object> yourEndpoint(@RequestHeader(name = "Authorization") String token,
			HttpServletRequest request) throws Exception {

		String username = jwtTokenUtil.extractUsername(token);

		if (username != null) {
			System.out.println("username is ::" + username);

			List<Transactions> transactions = transactionsService.getTransactionsByUserName(username);

			if (!transactions.isEmpty()) {
				System.out.println("size " + transactions.size());
				return ResponseEntity.ok(transactions);
			}

			throw new TransactionsNotFoundException("No Transsaction Found for this User: " + username);
		} else {
			throw new InvalidTokenException("Invalid Token Passed, Please try with Valid One");
		}

	}
}
