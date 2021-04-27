package com.catlinman.aoc.days;

import java.util.HashMap;

import com.catlinman.aoc.shared.Day;

public class Day3 extends Day {

	public Day3() {
		super(3);
	}

	@Override
	public int Part1(String[] argv) {
		super.Part1(argv);

		if (argv.length == 1) {
			String path = argv[0];

			String content = this.ReadFile(path);

			// Keep a record of all houses we will visit.
			HashMap<String, Integer> houses = new HashMap<String, Integer>() {
				private static final long serialVersionUID = 1L;

				{
					put("0,0", 1); // Initialize the record of houses with the starting position and initial value.
				}
			};

			// Santa's position.
			int x = 0;
			int y = 0;

			for (char c : content.toCharArray()) { // Traverse.
				switch (c) {
				case '<': // Move left.
					x -= 1;
					break;

				case '>': // Move right.
					x += 1;
					break;

				case '^': // Move up.
					y -= 1;
					break;

				case 'v': // Move down.
					y += 1;
					break;
				}

				// Generate a unique ID for the current visited house.
				String key = String.format("%d,%d", x, y);
				if (houses.containsKey(key)) {
					houses.put(key, houses.get(key) + 1);

				} else {
					houses.put(key, 1);
				}
			}

			System.out.printf("Santa visits a total of %d houses at least once.", houses.size());

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

			String content = this.ReadFile(path);

			// Keep a record of all houses we will visit.
			HashMap<String, Integer> houses = new HashMap<String, Integer>() {
				private static final long serialVersionUID = 1L;

				{
					put("0,0", 1); // Initialize the record of houses with the starting position and initial value.
				}
			};

			// Santa's position.
			int sx = 0;
			int sy = 0;

			// Robo-Santa's position.
			int rx = 0;
			int ry = 0;

			for (int i = 0; i < content.length(); i++) { // Begin traversing.

				// Alternate between Santa and Robo-Santa's positions.
				int x = (i % 2 == 0) ? sx : rx;
				int y = (i % 2 == 0) ? sy : ry;

				switch (content.charAt(i)) { // Traverse.
				case '<': // Move left.
					x -= 1;
					break;

				case '>': // Move right.
					x += 1;
					break;

				case '^': // Move up.
					y -= 1;
					break;

				case 'v': // Move down.
					y += 1;
					break;
				}

				// Re-assign our now updated values.
				if (i % 2 == 0) {
					sx = x;
					sy = y;

				} else {
					rx = x;
					ry = y;
				}
				
				// Generate a unique ID for the current visited house.
				String key = String.format("%d,%d", x, y);
				if (houses.containsKey(key)) {
					houses.put(key, houses.get(key) + 1);

				} else {
					houses.put(key, 1);
				}
			}

			System.out.printf("Santa and Robo-Santa visit a total of %d houses at least once.", houses.size());

			return 0;

		} else {
			System.out.println("Missing input file path.");

			return 1;
		}
	}
}
