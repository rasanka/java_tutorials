package com.ebees.designpattern.singleton;

public class LazyLoading {

	private static LazyLoading instance;
	
	private LazyLoading() {}
	
	public static LazyLoading getInstance() {
		if(instance == null) {
			instance = new LazyLoading();
		}
		
		return instance;
	}
}
