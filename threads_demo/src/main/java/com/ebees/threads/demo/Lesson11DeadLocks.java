package com.ebees.threads.demo;

class RunnerDemo {


	public void firstThread() throws InterruptedException {
	}

	public void secondThread() throws InterruptedException {
	}

	public void finished() {
	}
}

public class Lesson11DeadLocks {

	public static void main(String[] args) {

		final RunnerDemo runner = new RunnerDemo();
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
