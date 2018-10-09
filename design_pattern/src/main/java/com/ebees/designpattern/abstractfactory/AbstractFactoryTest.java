package com.ebees.designpattern.abstractfactory;

public class AbstractFactoryTest {
	
	public static void main(String args[]) {
		Computer pc = ComputerFactory.getComputer(new PCFactory("4GB", "1TB", "2.4GHz"));
		Computer server = ComputerFactory.getComputer(new ServerFactory("16GB", "5TB", "2.9GHz"));
		System.out.println(pc.toString());
		System.out.println(server.toString());
	}

}
