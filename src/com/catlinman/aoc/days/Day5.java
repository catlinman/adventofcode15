package com.catlinman.aoc.days;

import com.catlinman.aoc.shared.Day;

public class Day5 extends Day {

	private final String LETTERS = "abcdefghijklmnopqrstuvwxyz";
	private final String VOWELS = "aeiou";
	private final String[] NAUGHTY = new String[] { "ab", "cd", "pq", "xy" };
	
	public Day5() {
		super(5);
	}
	
	private boolean isNiceOld(String word) {
		// Convert the word to lower-case to make case matching easier and avoid errors.
		word = word.toLowerCase();
		
		// Check if there are double letters.
		boolean doubles = false;
		for (char letter : this.LETTERS.toCharArray()) {
			if (word.contains(Character.toString(letter).repeat(2))) {
				doubles = true;
				break;
			}
		}
		
		// Count the number of vowels.
		int vowels = 0;
		for (char vowel : this.VOWELS.toCharArray()) {
			if (word.contains(Character.toString(vowel))) {
				vowels += word.length() - word.replace(Character.toString(vowel), "").length();
			} 
		}
		
		// Check if any of the naughty words are in our word.
		boolean naughty = false;
		for (String nword : NAUGHTY) {
			if (word.contains(nword)) {
				naughty = true;
				break;
			}
		}
		
		// Make the return as complicated as possible.
		return doubles && vowels >= 3 && !naughty;
	}
	
	private boolean isNiceNew(String word) {
		// Convert the word to lower-case to make case matching easier and avoid errors.
		word = word.toLowerCase();
		
		// Check if there are double letters.
		boolean paired = false;
		for (char first : this.LETTERS.toCharArray()) {
			for (char second : this.LETTERS.toCharArray()) {
				int occurances = 0;
				
				String sliced = word;
				String pair = String.format("%s%s", Character.toString(first), Character.toString(second));
				
				while(sliced.contains(pair)) {
					sliced = sliced.substring(sliced.indexOf(pair) + 2);
					occurances++;
				}
				
				if (occurances >= 2) {
					paired = true;
					break;
				}
			}
			
			if (paired) {
				break;
			}
		}
		
		boolean sandwiched = false;
		for (char bun : this.LETTERS.toCharArray()) {
			String match = String.format(".*%s\\w%<s.*", Character.toString(bun));

			if (word.matches(match)) {
				sandwiched = true;
				break;
			}
		}
		
		return paired && sandwiched;
	}

	@Override
	public int Part1(String[] argv) {
		super.Part1(argv);

		if (argv.length == 1) {
			String path = argv[0];

			String[] words = this.ReadFileLines(path);
			
			int counter = 0;
			for(String word : words) {
				if(isNiceOld(word)) {
					counter++;
				}
			}
			
			System.out.printf("There are a total of %d nice words.", counter);

			return 0;

		} else {
			System.out.println("Missing input file path.");

			return 1;
		}
	}

	@Override
	public int Part2(String[] argv) {
		super.Part2(argv);

		if (argv.length == 1) {
			String path = argv[0];

			String[] words = this.ReadFileLines(path);
			
			int counter = 0;
			for(String word : words) {
				if(isNiceNew(word)) {
					System.out.println(word);
					
					counter++;
				}
			}
			
			System.out.printf("There are a total of %d nice words.", counter);

			return 0;

		} else {
			System.out.println("Missing input file path.");

			return 1;
		}
	}
}
