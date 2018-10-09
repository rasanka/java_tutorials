package com.ebees.designpattern.template;

public abstract class HouseTemplate {

	public final void buildHouse() {
		buildFoundation();
		buildPillars();
		buildWalls();
		buildWindows();
	}
	private void buildFoundation() {
		System.out.println("Building Foundation");
	}
	
	public abstract void buildPillars();
	public abstract void buildWalls();
	
	private void buildWindows() {
		System.out.println("Building Windows");
	}
}
