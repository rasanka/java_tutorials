package com.ebees.designpattern.builder;

public class BuilderTest {

	public  static void main(String args[]) {
		Computer pc = new Computer.ComputerBuilder("4GB", "1TB", "2.4GHz")
				.setBluetoothEnabled(true)
				.setGraphicCardEnabled(false)
				.build();
		
		System.out.println(pc.toString());
	}
}
