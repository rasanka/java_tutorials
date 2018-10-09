package com.ebees.designpattern.bridge;

public class RedColour implements Colour {

	@Override
	public void applyColour() {
		System.out.println("RED");
	}

}
