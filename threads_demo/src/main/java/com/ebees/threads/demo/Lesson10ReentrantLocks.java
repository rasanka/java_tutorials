package com.ebees.threads.demo;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Runner {

	private int count = 0;
	// By using the ReentrantLock class you can achieve the synchronization 
	// without using the synchronized keyword
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();
	
	private void increment() {
		for (int i = 0; i < 10000; i++) {
			count++;
		}
	}

	public void firstThread() throws InterruptedException {
		lock.lock();
		System.out.println("Waiting...");
		cond.await(); // Similar to wait()
		System.out.println("Woke up...");
		try {
			increment();
		} finally {
			lock.unlock();
		}
	}

	@SuppressWarnings("resource")
	public void secondThread() throws InterruptedException {
		
		Thread.sleep(1000); // just to ensure that the first thread triggered
		lock.lock();
		
		System.out.println("Hit enter to return...");
		new Scanner(System.in).nextLine();
		System.out.println("Enter pressed...");
		
		cond.signal();
		try {
			increment();
		} finally {
			lock.unlock();
		}
	}

	public void finished() {
		System.out.println("Count is : " + count);
	}
}

public class Lesson10ReentrantLocks {

	public static void main(String[] args) {

		final Runner runner = new Runner();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					runner.firstThread();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					runner.secondThread();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		runner.finished();
	}

}
