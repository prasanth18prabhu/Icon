package com.task;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.testng.annotations.Test;

public class StringManipulations {
	@Test

	public void removeCharacterDuplicate() {

		String name = "prasanthPSPS";

		LinkedHashSet<Character> set = new LinkedHashSet<Character>();

		for (int i = 0; i < name.length(); i++) {

			char ch = name.charAt(i);

			set.add(ch);

		}

		for (Character character : set) {

			System.out.print(character);

		}

	}

	@Test
	public void characterCount() {

		String name = "Welcome";

		Map<Character, Integer> map = new LinkedHashMap<>();

		char[] charArray = name.toCharArray();

		for (char ch : charArray) {

			if (map.containsKey(ch)) {

				int count = map.get(ch);

				map.put(ch, count + 1);

			} else {

				map.put(ch, 1);

			}

		}

		System.out.println(map);

	}

	@Test
	public void wordCount() {

		String name = "Welcome Everyone Welcome Team";

		Map<String, Integer> map = new LinkedHashMap<>();

		String[] split = name.split(" ");

		for (String word : split) {

			if (map.containsKey(word)) {

				int count = map.get(word);

				map.put(word, count + 1);

			} else {

				map.put(word, 1);

			}

		}

		System.out.println(map);
	}

	@Test
	public void removeDuplicateStringArray() {

		String name[] = { "11", "Good", "22", "33", "Good", "33" };

		String output = "";

		String duplicates = "";

		for (int i = 0; i < name.length; i++) {

			if (output.contains(name[i])) {

				duplicates = duplicates + name[i] + ",";

			} else {

				output = output + name[i] + ",";

			}

		}

		System.out.println(output);

		System.out.println(duplicates);

	}

	@Test
	public void removeDuplicateWords() {

		String removedData = "";

		String a = "Hi Hello Hi Ho hi";

		String x[] = a.split(" ");

		Set<String> s = new LinkedHashSet<>(Arrays.asList(x));

		for (String output : s) {

			removedData = removedData + output + " ";

		}

		System.out.println(removedData.trim());

	}

	@Test
	public void removeDuplicateAscending() {

		int numbers[] = { 10000, 10, 10, 5, 5, 20, 20, 100, 50, 60, 60, 70 };

		Set<Integer> set = new TreeSet<>();

		for (int i = 0; i < numbers.length; i++) {

			set.add(numbers[i]);

		}

		for (Integer removedData : set) {

			System.out.println(removedData);

		}
	}

	@Test
	public void removeDuplicateDescending() {

		int numbers[] = { 10, 20, 20, 100, 50, 60, 212, 212, 60, 70 }, temp;

		Set<Integer> s = new HashSet<>();

		for (int i = 0; i < numbers.length; i++) {

			s.add(numbers[i]);

		}

		Object[] ar = s.toArray();

		int b[] = new int[ar.length];

		for (int i = 0; i < ar.length; i++) {

			b[i] = (int) ar[i];

		}

		for (int i = 0; i < b.length; i++) {

			for (int j = i + 1; j < b.length; j++) {

				if (b[i] < b[j]) {

					temp = b[i];

					b[i] = b[j];

					b[j] = temp;

				}

			}

		}

		for (int i = 0; i < b.length; i++) {

			System.out.println(b[i]);

		}

	}

}