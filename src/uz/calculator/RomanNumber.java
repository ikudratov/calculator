package uz.calculator;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumber {
	public String intToRoman(int num) {
		int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] romanLetters = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		StringBuilder roman = new StringBuilder();
		for (int i = 0; i < values.length; i++) {
			while (num >= values[i]) {
				num = num - values[i];
				roman.append(romanLetters[i]);
			}
		}
		return roman.toString();
	}
	
	public static final int romanToInteger(String s) {

		Map<Character, Integer> values = new LinkedHashMap<Character, Integer>();
		values.put('I', 1);
		values.put('V', 5);
		values.put('X', 10);
		values.put('L', 50);
		values.put('C', 100);
		values.put('D', 500);
		values.put('M', 1000);

		int number = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i+1 == s.length() || values.get(s.charAt(i)) >= values.get(s.charAt(i + 1))) {
				number += values.get(s.charAt(i));
			} else {
				number -= values.get(s.charAt(i));
			}
		}
		return number;
	}
}
