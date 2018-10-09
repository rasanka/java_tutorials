package com.ebees.designpattern.command;

public class WriteFileCommand implements Command {

	private FSReceiver fileSystem;
	
	public WriteFileCommand(FSReceiver fs) {
		this.fileSystem = fs;
	}
	
	@Override
	public void execute() {
		this.fileSystem.writeFiles();
	}

}
