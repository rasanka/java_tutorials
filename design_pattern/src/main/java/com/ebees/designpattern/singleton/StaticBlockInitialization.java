package com.ebees.designpattern.singleton;

public class StaticBlockInitialization {

	private static StaticBlockInitialization instance;
	
	private StaticBlockInitialization() {}
	
	static {
		try {
			instance = new StaticBlockInitialization();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	public static StaticBlockInitialization getInstance() {
		return instance;
	}
}
