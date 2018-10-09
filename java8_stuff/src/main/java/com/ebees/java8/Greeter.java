package com.ebees.java8;

public class Greeter {
	
	public void greet(Greeting greet) {
		greet.perform();
	}

	public static void main(String[] args) {
		Greeting greet = new HelloOopGreeter();
		//greeter.greet(greet);
		greet.perform();
		
		Greeting lambdaGreet = () -> System.out.println("Hello Java8");
		lambdaGreet.perform();
		
		Greeting annonymousClass = new Greeting() {
			public void perform() {
				System.out.println("Hello Annonymous");
			}
		};
		
		annonymousClass.perform();
		
		ITwoIntParam twoParam = (int x, int y) -> x+y;
		System.out.println(twoParam.sum(3, 5));
	}

}
