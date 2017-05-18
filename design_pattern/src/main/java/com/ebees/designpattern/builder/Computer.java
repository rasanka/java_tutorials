package com.ebees.designpattern.builder;

public class Computer {

	private String HDD, RAM, CPU;
	private boolean isGraphicCardEnabled, isBluetoothEnabled;

	public String getHDD() {
		return HDD;
	}
	public String getRAM() {
		return RAM;
	}
	public String getCPU() {
		return CPU;
	}
	public boolean isGraphicCardEnabled() {
		return isGraphicCardEnabled;
	}
	public boolean isBluetoothEnabled() {
		return isBluetoothEnabled;
	}
	
	public String toString() {
		return " RAM - "+this.getRAM()+" HDD - "+this.getHDD()+" CPU - "+this.getCPU();
	} 

	private Computer(ComputerBuilder builder) {
		this.RAM = builder.RAM;
		this.HDD = builder.HDD;
		this.CPU = builder.CPU;
		this.isGraphicCardEnabled = builder.isGraphicCardEnabled;
		this.isBluetoothEnabled = builder.isBluetoothEnabled;
	}
	
	public static class ComputerBuilder {
		private String RAM,HDD,CPU;
		private boolean isGraphicCardEnabled, isBluetoothEnabled;
		
		public ComputerBuilder(String RAM, String HDD, String CPU) {
			this.RAM = RAM;
			this.HDD = HDD;
			this.CPU = CPU;
		}
		
		public ComputerBuilder setGraphicCardEnabled(boolean isGraphicCardEnabled) {
			this.isGraphicCardEnabled = isGraphicCardEnabled;
			return this;
		}
		
		public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
			this.isBluetoothEnabled = isBluetoothEnabled;
			return this;
		}
		
		public Computer build() {
			return new Computer(this);
		}
		
	}
}
