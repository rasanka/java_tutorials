package com.ebees.designpattern.adapter;

public class AdapterTest {

	public static void main(String args[]) {
		
		testClassAdapter();
		testObjAdapter();
	}
	
	private static void testClassAdapter() {
		SocketAdapter adapter = new SocketClassAdapterImpl();
		Volt v3 = adapter.get3();
		Volt v12 = adapter.get12();
		Volt v120 = adapter.get120();
		
		System.out.println(v3.getVolt()+" - "+v12.getVolt()+" - "+v120.getVolt());
	}
	
	private static void testObjAdapter() {
		SocketAdapter adapter = new SocketObjectAdapterImpl();
		Volt v3 = adapter.get3();
		Volt v12 = adapter.get12();
		Volt v120 = adapter.get120();
		
		System.out.println(v3.getVolt()+" - "+v12.getVolt()+" - "+v120.getVolt());
	}
}
