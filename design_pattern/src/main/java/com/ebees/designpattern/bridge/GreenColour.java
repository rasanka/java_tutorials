package com.ebees.designpattern.bridge;

public class GreenColour implements Colour {

	@Override
	public void applyColour() {
		System.out.println("GREEN");
	}

}
