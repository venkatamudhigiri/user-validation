package com.user.entity;

import java.math.BigDecimal;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@jakarta.persistence.Entity
public class Transactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;

	private String description;

	private String transactionDate;

	private BigDecimal amount;

	private String currency;

	private String status;

	// Constructors, getters, and setters

	public Transactions() {
		// Default constructor required by JPA
	}

	public Transactions(String username, String description, String transactionDate, BigDecimal amount, String currency,
			String status) {
		this.username = username;
		this.description = description;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.currency = currency;
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Transactions [id=" + id + ", username=" + username + ", description=" + description
				+ ", transactionDate=" + transactionDate + ", amount=" + amount + ", currency=" + currency + ", status="
				+ status + "]";
	}

}
