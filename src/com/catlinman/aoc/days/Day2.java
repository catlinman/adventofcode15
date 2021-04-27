package com.catlinman.aoc.days;

import java.util.Arrays;

import com.catlinman.aoc.shared.Day;

public class Day2 extends Day {

	public Day2() {
		super(2);
	}

	@Override
	public int Part1(String[] argv) {
		super.Part1(argv);

		if (argv.length == 1) {
			String path = argv[0];

			String[] boxes = this.ReadFileLines(path);

			int total = 0;
			for (String box : boxes) {
				String[] values = box.split("x");

				if (values.length != 3) {
					System.out.println("Invalid amount of box dimensions, expected 3.");
				}

				try {
					int l = Integer.parseInt(values[0]);
					int w = Integer.parseInt(values[1]);
					int h = Integer.parseInt(values[2]);

					int[] sides = new int[] { l * w, w * h, h * l };
					Arrays.sort(sides); // Sort the sides array to have the smallest value be at index 0.

					total += ((sides[0] + sides[1] + sides[2]) * 2) + sides[0];

				} catch (NumberFormatException e) {
					System.out.println("Value is not an integer.");
				}
			}

			System.out.printf("The total square feet of wrapping paper the silly elfs should order is %d!", total);

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

			String[] boxes = this.ReadFileLines(path);

			int total = 0;
			for (String box : boxes) {
				String[] values = box.split("x");

				if (values.length != 3) {
					System.out.println("Invalid amount of box dimensions, expected 3.");
				}

				try {
					int[] lengths = new int[] {
						Integer.parseInt(values[0]),
						Integer.parseInt(values[1]),
						Integer.parseInt(values[2])
					};

					Arrays.sort(lengths); // Sort the sides array to have the smallest value be at index 0.

					total += (lengths[0] * 2 + lengths[1] * 2) + (lengths[0] * lengths[1] * lengths[2]);

				} catch (NumberFormatException e) {
					System.out.println("Value is not an integer.");
				}
			}

			System.out.printf("The total length of ribbon is the funny elfs should order is %d!", total);

			return 0;

		} else {
			System.out.println("Missing input file path.");

			return 1;
		}
	}

}
