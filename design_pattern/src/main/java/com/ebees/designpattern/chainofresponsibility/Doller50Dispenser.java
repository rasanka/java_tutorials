package com.ebees.designpattern.chainofresponsibility;

public class Doller50Dispenser implements DispenseChain {

	private DispenseChain chain;
	
	@Override
	public void setNextChain(DispenseChain chain) {
		this.chain = chain;
	}

	@Override
	public void dispence(Currency currency) {
		if(currency.getAmount() >= 50) {
			int num = currency.getAmount() / 50;
			int rem = currency.getAmount() % 50;
			System.out.println("Dispensing "+num+" $50 notes");
			if (rem != 0) this.chain.dispence(new Currency(rem));
		} else {
			this.chain.dispence(currency);
		}
	}

}
