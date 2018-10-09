package com.ebees.designpattern.proxy;

public class ProxyTest {

	public static void main(String args[]) {
		CommandExecutor executor = new CommandExecutorProxy("ADMIN", "TEST");
		
		try {
			executor.runCommand("ping localhost");
			executor.runCommand("rm -d ");
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Exception Message :"+e.getMessage());
		}
		
	}
}
