package com.publicis.poc.utilities;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {

	public boolean validateCard(String cardNumber) {
		int sum = 0;
		try {
			//let card number = 79927398713
			int length = cardNumber.length(); //length 11
			for (int i = length; i > 0; i--) {
				int digit = Integer.parseInt(cardNumber.substring(i-1,i));
				if((cardNumber.length()-(i-1))%2 == 0) {
					digit = doubleAndSumDigits(digit);
				}
				System.out.println("Digit   "+digit);
				System.out.println(i);
				sum = sum+digit;
			}
			
			return sum%10 == 0;			
		} catch (Exception e) {
			System.out.println("error message: " + e.getMessage());
		}
		return false;
	}

	private int doubleAndSumDigits(int digit) {
		int ret = digit*2;
		if(ret > 9) {
			ret =  ret-9;
		}
		return ret;
	}
}
