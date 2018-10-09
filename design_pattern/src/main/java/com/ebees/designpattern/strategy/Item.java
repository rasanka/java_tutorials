package com.ebees.designpattern.strategy;

public class Item {

	private String code;
	private int price;

	public Item(String code, int price) {
		super();
		this.code = code;
		this.price = price;
	}

	public String getCode() {
		return code;
	}
	public int getPrice() {
		return price;
	}

}
