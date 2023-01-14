package com.publicis.poc.interfaces;

import java.util.List;

import com.publicis.poc.models.CreditCard;
import com.publicis.poc.models.CreditTransactions;

public interface ICreditCard {

	CreditCard addCreditCard(CreditCard creditCardDetails);

	List<CreditCard> findAllCreditCards();

	CreditCard createTransaction(CreditTransactions request);

}
