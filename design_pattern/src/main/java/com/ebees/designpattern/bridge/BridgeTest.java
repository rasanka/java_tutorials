package com.ebees.designpattern.bridge;

public class BridgeTest {

	public static void main(String args[]) {
		Shape triangle = new Triangle(new RedColour());
		Shape circle = new Circle(new GreenColour());
		
		triangle.applyColour();
		circle.applyColour();
	}
}
