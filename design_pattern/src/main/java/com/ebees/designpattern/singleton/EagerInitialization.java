package com.ebees.designpattern.singleton;

public class EagerInitialization {

	private static final EagerInitialization instance = new EagerInitialization();
	
	private EagerInitialization() {}
	
	public static EagerInitialization getInstance() {
		return instance;
	}
}
