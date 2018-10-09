package com.ebees.threads.demo;

class MyRunnable implements Runnable {

	@Override
	public void run() {
		for(int i =0; i < 10; i++) {
			System.out.println(Thread.currentThread().getId()+" - I - "+i);
		}
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class MyThread extends Thread {

	@Override
	public void run() {
		for(int i =0; i < 10; i++) {
			System.out.println(Thread.currentThread().getId()+" - I - "+i);
		}
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

public class Lesson1BasicThread {
	
	public static void main(String args[]) {
//		MyThread t1 = new MyThread();
//		t1.start();
//		MyThread t2 = new MyThread();
//		t2.start();
		
		Thread t1 = new Thread(new MyRunnable());
		t1.start();
		Thread t2 = new Thread(new MyRunnable());
		t2.start();
	}

}
