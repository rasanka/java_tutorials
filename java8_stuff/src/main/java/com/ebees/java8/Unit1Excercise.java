package com.ebees.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1Excercise {

	public static void main(String args[]) {

		List<Person> personList = Arrays.asList(
				new Person("Gilbert", "Santos", 40), 
				new Person("Rasa", "Jay", 34),
				new Person("Dil", "Muthu", 34), 
				new Person("Ranu", "Akein", 4), 
				new Person("Dinu", "Ashen", 3));

		// Step 01 - Sort the list using the last name
		Collections.sort(personList, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getlName().compareTo(o2.getlName());
			}
		});

		System.out.println("-----------------------------------------------");
		// Step 02 - Print all
		printAll(personList);

		System.out.println("-----------------------------------------------");
		// Step 03 - Print all where the last name starts with A
		printConditionally(personList, new Condition() {

			@Override
			public boolean test(Person p) {
				return p.getlName().startsWith("A");
			}
		});

		System.out.println("-----------------------------------------------");
		// Step 04 - Print all the adults who's age over 12
		printConditionally(personList, new Condition() {
			
			@Override
			public boolean test(Person p) {
				return p.getAge() > 12;
			}
		});
	}

	private static void printConditionally(List<Person> personList, Condition condition) {
		for (Person person : personList) {
			if (condition.test(person)) {
				System.out.println(person);
			}
		}
	}

	private static void printAll(List<Person> personList) {
		for (Person person : personList) {
			System.out.println(person);
		}
	}
}

interface Condition {
	public boolean test(Person p);
}