package com.ebees.designpattern.command;

public class CloseFileCommand implements Command {

	private FSReceiver fileSystem;
	
	public CloseFileCommand(FSReceiver fs) {
		this.fileSystem = fs;
	}
	
	@Override
	public void execute() {
		this.fileSystem.closeFile	();
	}

}
