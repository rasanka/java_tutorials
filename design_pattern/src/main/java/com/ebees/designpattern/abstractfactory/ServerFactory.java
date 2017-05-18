package com.ebees.designpattern.abstractfactory;

public class ServerFactory implements ComputerAbstractFactory {

	private String ram, hdd, cpu;
	
	public ServerFactory(String ram, String hdd, String cpu) {
		super();
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	@Override
	public Computer createComputer() {
		return new Server(ram, hdd, cpu);
	}

}
