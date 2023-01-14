package com.publicis.poc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.publicis.poc.interfaces.ICreditCard;
import com.publicis.poc.models.CreditCard;
import com.publicis.poc.models.CreditTransactions;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class CreditCardController {
	
	@Autowired
	private ICreditCard creditCardService;
	
	@PostMapping("/card")
	public ResponseEntity<CreditCard> createCreditCard(@RequestBody CreditCard request) {
		CreditCard _card = creditCardService.addCreditCard(request);
		return new ResponseEntity<>(_card, HttpStatus.CREATED);
	}
	
	@GetMapping("/cards")
    public List<CreditCard> findAllCreditCardDetails(){
        return creditCardService.findAllCreditCards();
    }
	
	@PostMapping("/transaction")
	public ResponseEntity<CreditCard> transactionEvent(@RequestBody CreditTransactions request) {
		CreditCard _creditDetails = this.creditCardService.createTransaction(request);
		return new ResponseEntity<>(_creditDetails, HttpStatus.CREATED);
	}
}
