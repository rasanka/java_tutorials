package com.ebees.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

public class Drawing implements Shape {
	
	List<Shape> shapes = new ArrayList<>();

	@Override
	public void draw(String colour) {
		for(Shape s : shapes) {
			s.draw(colour);
		}
	}

	public void add(Shape s) {
		shapes.add(s);
	}
	
	public void remove(Shape s) {
		shapes.remove(s);
	}
	
	public void clear() {
		shapes.clear();
	}
}
