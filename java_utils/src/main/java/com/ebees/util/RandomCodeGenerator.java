package com.ebees.util;

import java.util.Random;

public class RandomCodeGenerator {
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static Random rnd = new Random();
	static int codeLength = 8;

	public static void main(String args[]) {
		System.out.println(randomString());
	}

	public static String randomString() {
		StringBuilder sb = new StringBuilder(codeLength);
		for (int i = 0; i < codeLength; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}
}
