package com.ebees.designpattern.proxy;

public class CommandExecutorProxy implements CommandExecutor {
	
	private boolean isAdmin;
	private CommandExecutor executor;

	public CommandExecutorProxy(String user, String pwd) {
		if("ADMIN".equals(user) && "PWD".equals(pwd)) {
			isAdmin = true;
		}
		executor = new CommandExecutorImpl();
	}
	
	@Override
	public void runCommand(String cmd) throws Exception {
		if(isAdmin) {
			executor.runCommand(cmd);
		} else {
			if(cmd.startsWith("rm")) {
				throw new Exception("rm Command can not be used by NON Admin");
			} else {
				executor.runCommand(cmd);
			}
		}
	}

}
