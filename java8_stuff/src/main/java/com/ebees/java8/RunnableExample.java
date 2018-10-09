package com.ebees.java8;

public class RunnableExample {

	public static void main(String args[]) {
		
		Thread myTherad = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Pure Runnable Thread ");
			}
		});
		
		myTherad.run();
		
		Thread lambdaThread = new Thread(() -> System.out.println("Lambda Thread"));
		lambdaThread.run();
	}
}
