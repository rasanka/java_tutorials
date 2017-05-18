package com.ebees.designpattern.command;

public class CommandTest {

	public static void main(String args[]) {
		FSReceiver fs = FSReceiverUtil.getReceiver();
		
		OpenFileCommand openCmd = new OpenFileCommand(fs);
		FileInvoker file = new FileInvoker(openCmd);
		file.execute();
		
		WriteFileCommand writeCmd = new WriteFileCommand(fs);
		file = new FileInvoker(writeCmd);
		file.execute();
		
		CloseFileCommand closeCmd = new CloseFileCommand(fs);
		file = new FileInvoker(closeCmd);
		file.execute();
		
	}
}
