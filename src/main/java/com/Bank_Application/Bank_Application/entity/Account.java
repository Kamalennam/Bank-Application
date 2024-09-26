package com.Bank_Application.Bank_Application.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
	@SequenceGenerator(name = "account_seq", sequenceName = "account_sequence", allocationSize = 1)
	private Long accountId;

	@Column(nullable = false , unique = true)
	private Long accountNumber;		
	@Column(nullable = false)
	private String accountType;
	private double balance;
//	private LocalDate createdDate;
//	@Column(nullable = false)
	private String Status;
	
    @ManyToOne
    @JoinColumn(name = "user_id")
	private User user;

	private LocalDateTime createdDate;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	  public LocalDateTime getCreatedDate() {
	        return createdDate;
	    }

	    public void setCreatedDate(LocalDateTime createdDate) {
	        this.createdDate = createdDate;
	    }

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountNumber=" + accountNumber + ", accountType=" + accountType
				+ ", balance=" + balance + ", createdDate=" + createdDate + ", Status=" + Status + ", user=" + user
				+ "]";
	}

	public void setCreatedDate2(LocalDateTime createdDate) {
		this.createdDate = createdDate;
		
	}
	

//	public LocalDateTime getCreatedDate(LocalDateTime now) {
//		return LocalDateTime.now();
//		
//	}
	
}
