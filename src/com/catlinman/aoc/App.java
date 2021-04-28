package com.catlinman.aoc;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.catlinman.aoc.shared.Day;
import com.catlinman.aoc.days.*;

public class App {
	final static Day DAYS[] = { new Day1(), new Day2(), new Day3(), new Day4(), new Day5() };

	private static short getDay() {
		System.out.println("Please enter the day you would like to run: ");

		// Create a new scanner to read from the command line.
		Scanner scanner = new Scanner(System.in);

		try { // Scan the next integer from the command line.
			return scanner.nextShort();

		} catch (InputMismatchException e2) {
			System.out.println("Don't do that");
		}

		return 0;
	}

	private static short getPart() {
		System.out.println("Please enter the part you would like to run (1/2): ");

		// Create a new scanner to read from the command line.
		Scanner scanner = new Scanner(System.in);

		try { // Scan the next integer from the command line.
			return scanner.nextShort();

		} catch (InputMismatchException e2) {
			System.out.println("Don't do that either");
		}

		return 0;
	}

	public static void main(String[] argv) {
		short day = 0;
		short part = 0;

		if (argv.length >= 2) {
			try {
				// Try to parse the command line parameters.
				day = Short.parseShort(argv[0]);
				part = Short.parseShort(argv[1]);

			} catch (NumberFormatException e) {
				// If the formatting is wrong, ask for user input.
				day = getDay();
				part = getPart();

			}

			// Remove previous arguments.
			argv = Arrays.copyOfRange(argv, 2, argv.length);

		} else {
			// If no arguments were specified, ask for user input regardless.
			day = getDay();
			part = getPart();
		}

		if (day == 0 || part == 0) {
			System.out.println("Invalid day or part specified.");

			System.exit(1);
		}

		int total = DAYS.length;
		if (total < day) {
			System.out.printf("Day %d is not implemented yet - total amount of days are %d", day, total);

			System.exit(1);
		}

		switch (part) {
		case 1:
			System.exit(DAYS[day - 1].Part1(argv));
			break;

		case 2:
			System.exit(DAYS[day - 1].Part2(argv));
			break;

		default:
			System.out.printf("Part %d is not available (only 1 & 2 are accepted parameters).", part);

			System.exit(1);
		}
	}
}
