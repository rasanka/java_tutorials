package com.ebees.threads.demo;

public class Lesson2AnnonymousClass {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				printVal();
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}


		});
		
		t1.start();
	}
	
	private static void printVal() {
		for(int i =0; i < 10; i++) {
			System.out.println(Thread.currentThread().getId()+" - I - "+i);
		}
	}
	
	

}
