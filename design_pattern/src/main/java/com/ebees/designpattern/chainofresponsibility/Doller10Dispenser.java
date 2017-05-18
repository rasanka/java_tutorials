package com.ebees.designpattern.chainofresponsibility;

public class Doller10Dispenser implements DispenseChain {

	private DispenseChain chain;
	
	@Override
	public void setNextChain(DispenseChain chain) {
		this.chain = chain;
	}

	@Override
	public void dispence(Currency currency) {
		if(currency.getAmount() >= 10) {
			int num = currency.getAmount() / 10;
			int rem = currency.getAmount() % 10;
			System.out.println("Dispensing "+num+" $10 notes");
			if (rem != 0) this.chain.dispence(new Currency(rem));
		} else {
			this.chain.dispence(currency);
		}
	}

}
