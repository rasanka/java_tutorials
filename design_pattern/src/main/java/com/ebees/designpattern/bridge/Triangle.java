package com.ebees.designpattern.bridge;

public class Triangle extends Shape {

	public Triangle(Colour c) {
		super(c);
	}

	@Override
	public void applyColour() {
		System.out.println("Applying colour to Triangle");
		c.applyColour();
	}

}
