package com.ebees.threads.demo;

import java.util.LinkedList;
import java.util.Random;

class DemoProcessor {

	private LinkedList<Integer> list = new LinkedList<>();
	private final int LIMIT = 10;
	private Object lock = new Object();

	public void produce() throws InterruptedException {

		int value = 0;
		while (true) {
			synchronized (lock) {
				while(list.size() == LIMIT) {
					lock.wait();
				}
				list.add(value++);
				lock.notify();
			}
		}
	}

	public void consume() throws InterruptedException {
		Random random = new Random();
		while (true) {
			synchronized (lock) {
				while (list.size() == 0) {
					lock.wait();
				}
				System.out.println("List SIZE -" + list.size());
				int value = list.removeFirst();
				System.out.println("Value is : " + value);
				lock.notify();
			}
			Thread.sleep(random.nextInt(1000));
		}
	}
}

public class Lesson9NotifyWaitExample {

	public static void main(String[] args) throws InterruptedException {

		final DemoProcessor processor = new DemoProcessor();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processor.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processor.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t1.join();
	}

}
