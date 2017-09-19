package com.ebees.util;

import java.util.Map;

import com.google.common.base.Splitter;

public class GuavaTest {
	
	public static void main(String args[]) {
		String data = "user_id=ec7729e3-4b01-4b87-95c9-fa18e60b0a81, company_id=5a7c6899-a01c-498f-ac3c-c247d0e0c105".replaceAll(" ", "");
		
		Map<String, String> map = splitToMap(data);
		
		System.out.println(map);
		
		System.out.println(map.get("user_id"));
		
		System.out.println(map.get("company_id"));
	}

	private static Map<String, String> splitToMap(String in) {
		return Splitter.on(",").withKeyValueSeparator("=").split(in);
	}
}
