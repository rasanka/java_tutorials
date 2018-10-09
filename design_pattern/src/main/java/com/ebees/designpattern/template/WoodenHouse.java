package com.ebees.designpattern.template;

public class WoodenHouse extends HouseTemplate {

	@Override
	public void buildPillars() {
		System.out.println("Building Wooden house pillars");
	}

	@Override
	public void buildWalls() {
		System.out.println("Building Wooden house Walls");
	}

}
