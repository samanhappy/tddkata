package com.saman.roman2aribic;

import java.util.HashMap;
import java.util.Map;

public class Roman2Aribic {

	private int previousIncrement;

	private static Map<Character, Integer> ROMAN_2_ARIBIC = new HashMap<Character, Integer>();

	static {
		ROMAN_2_ARIBIC.put('I', 1);
		ROMAN_2_ARIBIC.put('V', 5);
		ROMAN_2_ARIBIC.put('X', 10);
		ROMAN_2_ARIBIC.put('L', 50);
		ROMAN_2_ARIBIC.put('C', 100);
		ROMAN_2_ARIBIC.put('D', 500);
		ROMAN_2_ARIBIC.put('M', 1000);
	}

	public int convert(String romanNumber) {
		int result = 0;
		char[] allSymbols = romanNumber.toCharArray();
		for (int index = allSymbols.length - 1; index >= 0; index--) {
			result += getIncrementBasedOnPreviousIncrement(ROMAN_2_ARIBIC
					.get(allSymbols[index]));
		}
		return result;
	}

	private int getIncrementBasedOnPreviousIncrement(int increment) {
		if (previousIncrement > increment)
			return -increment;
		else {
			previousIncrement = increment;
			return increment;
		}

	}
}
