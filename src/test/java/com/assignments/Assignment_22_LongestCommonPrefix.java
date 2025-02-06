package com.assignments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Assignment_22_LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Write a function to find the longest common prefix string amongst an array of
		 * strings. If there is no common prefix, return an empty string "". Example 1:
		 * Input: strs = ["flower","flow","flight"] Output: "fl" Example 2: Input: strs
		 * = ["dog","racecar","car"] Output: "" Explanation: There is no common prefix
		 * among the input strings. Constraints: • 1 <= strs.length <= 200 • 0 <=
		 * strs[i].length <= 200 • strs[i] consists of only lowercase English letters.
		 */
//		List<String>  input= new ArrayList<String>(List.of("dog","racecar","car")) ;
		List<String> input = new ArrayList<String>(List.of("flower", "flow", "flight"));

		if (commonPrefix(input).get(0).equals("")) {
			System.out.println("No Characters matched");
		} else {
			System.out.println(commonPrefix(input).get(0));
		}

	}

	public static List<String> commonPrefix(List<String> str) {
		List<String> outStr = new ArrayList<String>();
		String output = "";
		int min = str.get(0).length();
		String minStr = str.get(0);
		for (String string : str) {
			if (min > string.length()) {
				min = string.length();
				minStr = string;
			}
		}

		for (int i = 0; i < minStr.length() - 1; i++) {
			boolean flag = false;

			for (String str1 : str) {
				if (!minStr.equals(str1)) {

					if (minStr.charAt(i) == str1.charAt(i)) {

						flag = true;
					} else {
						flag = false;
						break;
					}

				}

			}
			if (flag == false) {
				break;
			} else {
				output += minStr.charAt(i);
			}

		}

		outStr.add(output);

		return outStr;

	}

}
