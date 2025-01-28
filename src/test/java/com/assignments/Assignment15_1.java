package com.assignments;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Assignment15_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 2. A phrase is a palindrome if, after converting all uppercase letters into
		 * lowercase letters and removing all non-alphanumeric characters, it reads the
		 * same forward and backward. Alphanumeric characters include letters and
		 * numbers. Given a string s, return true if it is a palindrome, or false
		 * otherwise.
		 * 
		 * Example 1: Input: s = "A man, a plan, a canal: Panama" Output: true
		 * Explanation: "amanaplanacanalpanama" is a palindrome.
		 * 
		 * Example 2: Input: s = "race a car" Output: false Explanation: "raceacar" is
		 * not a palindrome.
		 */

//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter String : ");
		String input = "A man, a plan, a canal: Panama";
//		String input = "race a car";
		String s = input.toLowerCase().replaceAll("[^a-z0-9]", "");
		boolean pal = checkStrPalindrom(s);
		if (pal == true) {
			System.out.println(s + " : Given string is a palindrome");
		} else {
			System.out.println(s + " : Given string is not a palindrome");
		}

	}

	public static boolean checkStrPalindrom(String s) {

		String newString = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			newString = newString + s.charAt(i);
		}
		if (newString.equals(s)) {
			return true;

		} else {
			return false;

		}

	}

}
