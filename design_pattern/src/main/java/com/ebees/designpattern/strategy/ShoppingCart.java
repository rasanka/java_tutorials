package com.ebees.designpattern.strategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	List<Item> items;

	public ShoppingCart() {
		this.items = new ArrayList<>();
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public void removeItem(Item item) {
		items.remove(item);
	}
	
	public int calculateTotal() {
		int total = 0;
		for (Item i : items) {
			total += i.getPrice();
		}
		return total;
	}
	
	public void pay(PaymentStratergy payMethod) {
		payMethod.pay(calculateTotal());
	}
}
