package com.publicis.poc.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.publicis.poc.errorhandler.CustomException;
import com.publicis.poc.interfaces.ICreditCard;
import com.publicis.poc.models.CreditCard;
import com.publicis.poc.models.CreditTransactions;
import com.publicis.poc.repositories.CreditCardRepository;
import com.publicis.poc.repositories.CreditTransactionsRepository;
import com.publicis.poc.utilities.ValidationService;

@Service
public class CreditCardService implements ICreditCard {

	@Autowired
	private CreditCardRepository cardRepository;
	
	@Autowired
	private CreditTransactionsRepository transactionsRepository;
	
	@Autowired
	private ValidationService validationService;
	
	@Override
	public CreditCard addCreditCard(CreditCard creditCardDetails) {
		
		boolean validateCard = this.validationService.validateCard(creditCardDetails.getCreditCardNumber());
		if(validateCard) {
			creditCardDetails.setCreditBalance(creditCardDetails.getCreditLimit());
			return this.cardRepository.save(creditCardDetails);
		}
		if(!validateCard) {
			throw new CustomException("Not a Valid Card Number");
		}
		return null;
	}

	@Override
	public List<CreditCard> findAllCreditCards() {
		return this.cardRepository.findAll();
	}

	@Override
	public CreditCard createTransaction(CreditTransactions request) {
		
		try {
			if(this.cardRepository.findById(request.getCard().getId()).isPresent()) {
				CreditCard _cardDetails = this.cardRepository.findById(request.getCard().getId()).get();
				if(_cardDetails.getCreditBalance() > request.getTransactionAmount()) {
					_cardDetails.setCreditBalance(_cardDetails.getCreditBalance()-request.getTransactionAmount());
					request.setCreditBalance(_cardDetails.getCreditBalance());
					request.setCard(_cardDetails);
					request.setCreatedAt(new Date());
					this.transactionsRepository.save(request);		
					return this.cardRepository.save(_cardDetails);
				}
			}
		} catch (Exception e) {
			
		}
		return null;
	}

}
