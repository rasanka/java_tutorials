package com.ebees.designpattern.strategy;

public class CreditCardStrategy implements PaymentStratergy {

	private String name, cardNo, cvv, expDate;
	
	public CreditCardStrategy(String name, String cardNo, String cvv, String expDate) {
		super();
		this.name = name;
		this.cardNo = cardNo;
		this.cvv = cvv;
		this.expDate = expDate;
	}

	@Override
	public void pay(int amount) {
		System.out.println("$"+amount + "paid using Credit Card");
	}

}
