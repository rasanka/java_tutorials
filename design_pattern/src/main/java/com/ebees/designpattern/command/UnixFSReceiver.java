package com.ebees.designpattern.command;

public class UnixFSReceiver implements FSReceiver {

	@Override
	public void openFile() {
		System.out.println("Opening file in UNIX");
	}

	@Override
	public void writeFiles() {
		System.out.println("Writing files in UNIX");
	}

	@Override
	public void closeFile() {
		System.out.println("Closing the file in UNIX");
	}

}
