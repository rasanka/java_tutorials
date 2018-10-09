package com.ebees.designpattern.composite;

public class CompositeTest {

	public static void main(String args[]) {
		Shape t1 = new Triangle();
		Shape t2 = new Triangle();
		Shape c1 = new Circle();
		
		t1.draw("GREEN");
		
		System.out.println("----------------------------");
		
		Drawing d = new Drawing();
		d.add(t1);
		d.add(t2);
		d.add(c1);
		
		d.draw("RED");
		
	}
}
