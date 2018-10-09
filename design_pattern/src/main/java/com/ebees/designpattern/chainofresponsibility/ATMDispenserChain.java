package com.ebees.designpattern.chainofresponsibility;

import java.util.Scanner;

public class ATMDispenserChain {

	private DispenseChain c50;
	
	public ATMDispenserChain() {
		this.c50 = new Doller50Dispenser();
		DispenseChain c20 = new Doller20Dispenser();
		DispenseChain c10 = new Doller10Dispenser();
		
		c50.setNextChain(c20);
		c20.setNextChain(c10);
	}
	
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		ATMDispenserChain atm = new ATMDispenserChain();
		while(true) {
			int amount = 0;
			System.out.println("Enter amount to dispense?");
			amount = new Scanner(System.in).nextInt();
			if(amount % 10 != 0) {
				System.out.println("Amount should be in multiples of 10's");
				return;
			}
			atm.c50.dispence(new Currency(amount));
		}
	}
}
