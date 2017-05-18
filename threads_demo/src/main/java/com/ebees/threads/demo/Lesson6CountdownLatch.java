package com.ebees.threads.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class LatchProcessor implements Runnable {
	
	// this is thread safe class so no need to use Synchronized
	private CountDownLatch latch;

	public LatchProcessor(CountDownLatch latch) {
		this.latch = latch;
	}
	
	@Override
	public void run() {
		System.out.println("Started...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		latch.countDown(); // Decrement the count by 1
	}
	
}


public class Lesson6CountdownLatch {

	public static void main(String[] args) {
		
		// Threads can use the latch where when it becomes 0 to return
		CountDownLatch latch = new CountDownLatch(3);
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for(int i =0; i < 3; i++) {
			executor.submit(new LatchProcessor(latch));
		}
		
		try {
			// Waiting till the latch becomes zero
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Completed..");
	}

}
