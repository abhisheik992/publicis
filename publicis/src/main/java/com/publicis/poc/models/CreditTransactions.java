package com.publicis.poc.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Credit_Transactions")
public class CreditTransactions {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonProperty(access = Access.WRITE_ONLY)
	@JoinColumn(name = "credit_card_id", referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.ALL)
	private CreditCard card;

	@Column(name = "transaction_amount")
	private double transactionAmount;

	@Column(name = "credit_balance")
	private double creditBalance;
	
	@Column(name = "created_time")
	private Date createdAt;

	public CreditTransactions() {
		super();
	}

	public CreditTransactions(Long id, CreditCard card, double transactionAmount, double creditBalance,
			Date createdAt) {
		super();
		this.id = id;
		this.card = card;
		this.transactionAmount = transactionAmount;
		this.creditBalance = creditBalance;
		this.createdAt = createdAt;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CreditCard getCard() {
		return card;
	}

	public void setCard(CreditCard card) {
		this.card = card;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public double getCreditBalance() {
		return creditBalance;
	}

	public void setCreditBalance(double creditBalance) {
		this.creditBalance = creditBalance;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "CreditTransactions [id=" + id + ", card=" + card + ", transactionAmount=" + transactionAmount
				+ ", creditBalance=" + creditBalance + "]";
	}

}
