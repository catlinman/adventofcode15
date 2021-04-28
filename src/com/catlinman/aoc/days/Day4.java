package com.catlinman.aoc.days;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.stream.IntStream;

import com.catlinman.aoc.shared.Day;

public class Day4 extends Day {

	public Day4() {
		super(4);
	}
	
	public int detectZeros(int amount, String secret) {
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();

			return -1;
		}
		
		int salt = 0;
		
		while (true) {
			byte[] hash = md5.digest(String.format("%s%d", secret, salt).getBytes());

			String hex = "";
			for (byte b : hash) {
				hex = String.format("%s%02x", hex, b);
			}

			System.out.printf("Examining salt %d producing hash %s. \n", salt, hex);

			if (hex.substring(0, amount).equals("0".repeat(amount))) {
				return salt;
			}

			salt++;
		}
	}

	@Override
	public int Part1(String[] argv) {
		super.Part1(argv);

		if (argv.length == 1) {
			String path = argv[0];

			String secret = this.ReadFile(path);

			System.out.printf("Found hash with five leading zero bytes via salt of %d.", detectZeros(5, secret));

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

			String secret = this.ReadFile(path);

			System.out.printf("Found hash with six leading zero bytes via salt of %d.", detectZeros(6, secret));

			return 0;

		} else {
			System.out.println("Missing input file path.");

			return 1;
		}
	}
}
