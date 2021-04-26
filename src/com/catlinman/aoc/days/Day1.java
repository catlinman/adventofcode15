package com.catlinman.aoc.days;

import java.io.File;

import com.catlinman.aoc.shared.Day;

public class Day1 extends Day {

	public Day1() {
		super(1);
	}

	@Override
	public int Part1(String[] argv) {
		super.Part1(argv);

		if (argv.length == 1) {
			String path = argv[0];

			String content = this.ReadFile(path);

			int floor = 0;
			for (char c : content.toCharArray()) {
				switch (c) {
				case '(': // Santa will go up one floor.
					floor++;
					break;

				case ')': // Santa will go down.
					floor--;
					break;

				default:
					System.out.println("Santa is confused.");
				}
			}

			System.out.printf("Santa has arrived at floor %d.", floor);
			
			return 0;

		} else {
			System.out.println("Missing input file path.");

			return 1;
		}
	}

	@Override
	public int Part2(String[] argv) {
		super.Part2(argv); //

		if (argv.length == 1) {
			String path = argv[0];

			String content = this.ReadFile(path);

			int floor = 0;
			int i = 1;
			for (char c : content.toCharArray()) {
				switch (c) {
				case '(': // Santa will go up one floor.
					floor++;
					break;

				case ')': // Santa will go down.
					floor--;
					break;

				default:
					System.out.println("Santa is confused.");
				}

				if (floor < 0) {
					System.out.printf("Santa has found the basement after traversing %d floors.", i);
					return 0;
				}
				
				i++;
			}

			System.out.printf("Santa never found the basement.");
			
			return 0;

		} else {
			System.out.println("Missing input file path.");

			return 1;
		}
	}

}
