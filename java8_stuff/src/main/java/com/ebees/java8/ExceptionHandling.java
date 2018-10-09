package com.ebees.java8;

import java.util.function.BiConsumer;

public class ExceptionHandling {

	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5 };
		int key = 0;

		process(numbers, key, wrapperLambda((a, b) -> System.out.println(a / b)));

	}

	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
		return (a, b) -> {
			try {
				consumer.accept(a, b);
			} catch (ArithmeticException e) {
				System.out.println(" Error -"+e.getMessage());
			}
		};
	}

	private static void process(int[] numbers, int key, BiConsumer<Integer, Integer> consumer) {
		for (int i : numbers) {
			consumer.accept(i, key);
		}
	}

}
