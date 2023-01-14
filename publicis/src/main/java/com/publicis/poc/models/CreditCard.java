package com.publicis.poc.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Credit_Cards")
public class CreditCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Mandatory field Customer Name can not be null.")
	@NotBlank(message = "Mandatory field Customer Name can not be Blank.")
	@Column(name = "customer_name")
	private String creditHolder;

	@Pattern(regexp = "^[1-9][0-9]{10,19}$", message = "Not a Credit Card")
	@Column(name = "credit_card_number")
	private String creditCardNumber;

	@Column(name = "credit_limit")
	private double creditLimit;

	@Column(name = "credit_balance")
	private double creditBalance;

	@JsonProperty(access = Access.READ_ONLY)
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "credit_card_id")
	private List<CreditTransactions> creditTransactionsList;

	public CreditCard() {
		super();
	}

	public CreditCard(Long id, String creditHolder, String creditCardNumber, double creditLimit, double creditBalance,
			List<CreditTransactions> creditTransactionsList) {
		super();
		this.id = id;
		this.creditHolder = creditHolder;
		this.creditCardNumber = creditCardNumber;
		this.creditLimit = creditLimit;
		this.creditBalance = creditBalance;
		this.creditTransactionsList = creditTransactionsList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreditHolder() {
		return creditHolder;
	}

	public void setCreditHolder(String creditHolder) {
		this.creditHolder = creditHolder;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public double getCreditBalance() {
		return creditBalance;
	}

	public void setCreditBalance(double creditBalance) {
		this.creditBalance = creditBalance;
	}

	public List<CreditTransactions> getCreditTransactionsList() {
		return creditTransactionsList;
	}

	public void setCreditTransactionsList(List<CreditTransactions> creditTransactionsList) {
		this.creditTransactionsList = creditTransactionsList;
	}

	@Override
	public String toString() {
		return "CreditCard [id=" + id + ", creditHolder=" + creditHolder + ", creditCardNumber=" + creditCardNumber
				+ ", creditLimit=" + creditLimit + ", creditBalance=" + creditBalance + ", creditTransactionsList="
				+ creditTransactionsList + "]";
	}

}
