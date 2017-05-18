package com.ebees.designpattern.bridge;

public abstract class Shape {

	protected Colour c;
	
	public Shape(Colour c) {
		this.c = c;
	}
	
	abstract public void applyColour();
	
}
