package com.catlinman.aoc.days;

import com.catlinman.aoc.shared.Day;

public class Day4 extends Day {

	public Day4() {
		super(4);
	}

	
	@Override
	public int Part1(String[] argv) {
		super.Part1(argv);

		if (argv.length == 1) {
			String path = argv[0];

			String content = this.ReadFile(path);
			
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
			
			return 0;
					
		} else {
			System.out.println("Missing input file path.");

			return 1;
		}
	}
}
