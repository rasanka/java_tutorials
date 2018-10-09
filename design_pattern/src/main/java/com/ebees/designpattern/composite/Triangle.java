package com.ebees.designpattern.composite;

public class Triangle implements Shape {

	@Override
	public void draw(String colour) {
		System.out.println("Triangle drawing in -"+colour);
	}

}
