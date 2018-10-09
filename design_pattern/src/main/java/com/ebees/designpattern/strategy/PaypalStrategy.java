package com.ebees.designpattern.strategy;

public class PaypalStrategy implements PaymentStratergy {

	private String username, password;
	
	public PaypalStrategy(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public void pay(int amount) {
		System.out.println("$"+amount + "paid using Paypal");
	}

}
