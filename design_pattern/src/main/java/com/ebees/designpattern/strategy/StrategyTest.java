package com.ebees.designpattern.strategy;

public class StrategyTest {

	public static void main(String args[]) {
		
		ShoppingCart cart = new ShoppingCart();
		
		Item i1 = new Item("C1", 12);
		Item i2 = new Item("D1", 50);
		
		cart.addItem(i1);
		cart.addItem(i2);
		
		cart.pay(new CreditCardStrategy("Rasanka", "4324324234324", "123", "02/19"));
		
		cart.pay(new PaypalStrategy("rasanka", "342jgsd34e"));
	}
}
