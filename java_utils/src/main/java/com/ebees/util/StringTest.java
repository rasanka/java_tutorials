package com.ebees.util;

public class StringTest {

	public static void main(String args[]) {
		String data = "";
		
		data = "9Stuser@test.com";
		System.out.println(isAllowed(data));
		
		data = "9 Stuser@test.com";
		System.out.println(isAllowed(data));
		
		data = "PVTstuser@test.com";
		System.out.println(isAllowed(data));
		
		data = "user@9pvt.com";
		System.out.println(isAllowed(data));
	}

	public static boolean isAllowed(String value) {
		return !(value.toLowerCase().contains("9s") || value.toLowerCase().contains("9 s") || value.toLowerCase().matches("(pvt).*"));
	}
}
