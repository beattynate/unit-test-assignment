package com.promineotech;

import java.util.Random;

public class TestDemo {
	public int addPostive(int a, int b) {
		if (a >= 0 && b >= 0) {
			return a + b;
		}
		else throw new IllegalArgumentException("Both parameters must be positive!");
	}
	public Boolean palindrome (String word) {
		if (word == null) {
			throw new IllegalArgumentException();
		}
		StringBuilder reverseWord = new StringBuilder();
		for (int i = word.length() - 1; i > -1; i--) {
			reverseWord.append(word.charAt(i));
		}
		return reverseWord.toString().equalsIgnoreCase(word);
		}
	public int randomNumberSquared() {
		int number = getRandomInt();
		return number * number;
	}
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
		
	}
}

