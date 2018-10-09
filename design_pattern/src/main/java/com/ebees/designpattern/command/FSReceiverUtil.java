package com.ebees.designpattern.command;

public class FSReceiverUtil {

	public static FSReceiver getReceiver() {
		String osName = System.getProperty("os.name");
		System.out.println("Operating System - "+osName);
		if(osName.equals("Windows 10")) {
			return new WindowsFSReceiver();
		} else {
			return new UnixFSReceiver();
		}
	}
}
