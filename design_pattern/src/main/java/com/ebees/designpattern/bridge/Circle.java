package com.ebees.designpattern.bridge;

public class Circle extends Shape {

	public Circle(Colour c) {
		super(c);
	}

	@Override
	public void applyColour() {
		System.out.println("Applying colour to Circle");
		c.applyColour();
	}

}
