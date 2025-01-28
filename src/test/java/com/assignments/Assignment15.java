package com.assignments;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Assignment15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 1. String input = " I Love Dogs "; Print All 2 Letter word combinations from
		 * this and 2 chars should not have same letter
		 */
		String input = " I Love Dogs ";
		String s = input.replace(" ", "");
		int count = 0;
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		for (int i = 0; i < s.length(); i++) {
			for (int j = 1; j < s.length(); j++) {
				if (s.charAt(i) != s.charAt(j)) {
					map.put("" + s.charAt(i) + s.charAt(j), ++count);
					map.put("" + s.charAt(j) + s.charAt(i), ++count);
				}
			}
		}
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println(val + " : " + key);

		}
		System.out.println(map.size());

	}

}
