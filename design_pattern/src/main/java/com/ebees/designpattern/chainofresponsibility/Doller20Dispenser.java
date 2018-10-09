package com.ebees.designpattern.chainofresponsibility;

public class Doller20Dispenser implements DispenseChain {

	private DispenseChain chain;
	
	@Override
	public void setNextChain(DispenseChain chain) {
		this.chain = chain;
	}

	@Override
	public void dispence(Currency currency) {
		if(currency.getAmount() >= 20) {
			int num = currency.getAmount() / 20;
			int rem = currency.getAmount() % 20;
			System.out.println("Dispensing "+num+" $20 notes");
			if (rem != 0) this.chain.dispence(new Currency(rem));
		} else {
			this.chain.dispence(currency);
		}
	}

}
