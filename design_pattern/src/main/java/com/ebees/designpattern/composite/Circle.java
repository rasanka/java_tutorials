package com.ebees.designpattern.composite;

public class Circle implements Shape {

	@Override
	public void draw(String colour) {
		System.out.println("Circle drawing in - "+colour);
	}

}
