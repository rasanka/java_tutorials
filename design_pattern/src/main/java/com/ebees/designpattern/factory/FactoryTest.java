package com.ebees.designpattern.factory;

public class FactoryTest {

	public static void main(String args[]) {
		
		Computer pc = ComputerFactory.getComputer("PC", "4GB", "1TB", "2.4GHz");
		Computer server = ComputerFactory.getComputer("SERVER", "16GB", "5TB", "3.0GHz");
		
		System.out.println(pc.toString());
		System.out.println(server.toString());
	}
}
