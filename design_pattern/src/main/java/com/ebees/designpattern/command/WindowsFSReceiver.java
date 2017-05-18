package com.ebees.designpattern.command;

public class WindowsFSReceiver implements FSReceiver {

	@Override
	public void openFile() {
		System.out.println("Opening file in WINDOWS");
	}

	@Override
	public void writeFiles() {
		System.out.println("Writing files in WINDOWS");
	}

	@Override
	public void closeFile() {
		System.out.println("Closing the file in WINDOWS");
	}

}
