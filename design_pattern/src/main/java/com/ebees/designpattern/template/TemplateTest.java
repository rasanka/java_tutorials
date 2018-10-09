package com.ebees.designpattern.template;

public class TemplateTest {

	public static void main(String args[]) {
		HouseTemplate template = new WoodenHouse();
		
		template.buildHouse();
	}
}
