package com.ebees.util;

public class StringTest {

	public static void main(String args[]) {
	    
	    String test = "";
	    if(test.isEmpty()) {
	        System.out.println("EMPTY");
	    }
	    
	    String url = "/tenants/00000000-0000-0005-5555-555555555599/companies/4e0030d9-b729-4476-82a4-60c698781f7e";
	    System.out.println(url.indexOf("/tenants/"));
	    
	    System.out.println("---------------------------");
	    
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
