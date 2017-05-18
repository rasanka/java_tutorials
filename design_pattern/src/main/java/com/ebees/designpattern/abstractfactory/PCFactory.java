package com.ebees.designpattern.abstractfactory;

public class PCFactory implements ComputerAbstractFactory {
	
	private String ram, hdd, cpu;
	
	public PCFactory(String ram, String hdd, String cpu) {
		super();
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	@Override
	public Computer createComputer() {
		return new PC(ram, hdd, cpu);
	}

}
