package com.ebees.designpattern.command;

public class OpenFileCommand implements Command {

	private FSReceiver fileSystem;
	
	public OpenFileCommand(FSReceiver fs) {
		this.fileSystem = fs;
	}
	
	@Override
	public void execute() {
		this.fileSystem.openFile();
	}

}
