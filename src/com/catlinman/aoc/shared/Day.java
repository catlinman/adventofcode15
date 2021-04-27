package com.catlinman.aoc.shared;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class Day implements Puzzle {
	int number;
	
	public Day(int number) {
		this.number = number;
	}
	
	public int Part1(String[] argv) {
		System.out.printf("Running day %d, part 1. \n", this.number);
		return 0;
	}
	
	public int Part2(String[] argv) {
		System.out.printf("Running day %d, part 2. \n", this.number);
		return 0;
	}
	
	public String ReadFile(String path) {
		try {
			return new String(String.join("", Files.readAllLines(Paths.get(path))));

		} catch (IOException e) {
			System.out.println("The specified file could not be found.");
			System.exit(1);
		}

		return path;
	}
	
	public String[] ReadFileLines(String path) {
		try {
			return Files.readAllLines(Paths.get(path)).toArray(String[]::new);

		} catch (IOException e) {
			System.out.println("The specified file could not be found.");
			System.exit(1);
		}

		return new String[0];
	}
}