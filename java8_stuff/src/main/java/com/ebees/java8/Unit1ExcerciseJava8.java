package com.ebees.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Unit1ExcerciseJava8 {

	public static void main(String args[]) {

		List<Person> personList = Arrays.asList(
				new Person("Gilbert", "Santos", 40), 
				new Person("Rasa", "Jay", 34),
				new Person("Dil", "Muthu", 34), 
				new Person("Ranu", "Akein", 4), 
				new Person("Dinu", "Ashen", 3));

		// Step 01 - Sort the list using the last name
		Collections.sort(personList, (o1,o2) -> o1.getlName().compareTo(o2.getlName()));

		System.out.println("-----------------------------------------------");
		// Step 02 - Print all
		printConditionally(personList, p -> true, p -> System.out.println(p));

		System.out.println("-----------------------------------------------");
		// Step 03 - Print all where the last name starts with A
		printConditionally(personList, p -> p.getlName().startsWith("A"), p -> System.out.println(p.getlName()));

		System.out.println("-----------------------------------------------");
		// Step 04 - Print all the adults who's age over 12
		printConditionally(personList, p -> p.getAge() > 12, p -> System.out.println(p.getfName()));
	}

	private static void printConditionally(List<Person> personList, Predicate<Person> predicate, Consumer<Person> consumer) {
		for (Person person : personList) {
			if (predicate.test(person)) {
				consumer.accept(person);
			}
		}
	}

}
