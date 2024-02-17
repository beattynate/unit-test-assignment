package com.promineotech;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, Integer expected, boolean expectException) {
		if(!expectException) {
			assertEquals(testDemo.addPostive(a, b), expected);
		}else {
			assertThatThrownBy(() -> testDemo.addPostive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
				Arguments.arguments(2, 2, 4, false),
				Arguments.arguments(2, -3, null, true),
				Arguments.arguments(2, 0, 2, false),
				Arguments.arguments(65, 12, 77, false),
				Arguments.arguments(-2, -2, null, true)
				);
	}
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForPalindrome")
	void shouldReturnWhetherWordIsPalindrome(String word, Boolean isTrue, boolean expectException) {
		if(!expectException) {
			assertEquals(testDemo.palindrome(word), isTrue);
		}else {
			assertThatThrownBy(() -> testDemo.palindrome(word)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	static Stream<Arguments> argumentsForPalindrome(){
		return Stream.of(
				Arguments.arguments("dog", false, false),
				Arguments.arguments("racecar", true, false),
				Arguments.arguments("121", true, false),
				Arguments.arguments(null, null, true) 
					);
	}
	@Test
	void assetThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertEquals(fiveSquared, 25);
	}

}
