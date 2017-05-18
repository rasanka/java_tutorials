package com.ebees.designpattern.command;

public class FileInvoker {

	public Command cmd;
	
	public FileInvoker(Command cmd) {
		this.cmd = cmd;
	}
	
	public void execute() {
		this.cmd.execute();
	}
}
