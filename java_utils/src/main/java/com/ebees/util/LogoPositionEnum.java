package com.ebees.util;

public enum LogoPositionEnum {

	OUTSIDE_TOP_LEFT ("outsideTopLeft"),
	INSIDE_TOP_LEFT ("insideTopLeft"),
	NONE("none");
	
	private String key;
	
	private LogoPositionEnum(String key) {
		this.key = key;
	}
	
	public String getKey() {
		return key;
	}

}
