package com.task;

import org.testng.annotations.Test;

public class Loop {
	@Test
	public void numberPattern() {

		for (int i = 1; i <= 7; i++) {

			for (int j = 1; j <= i; j++) {

				System.out.print(j);

			}

			System.out.print("\n");

		}

	}

	@Test
	public void pyramidPattern() {

		int n = 5;

		for (int i = 0; i <= n; i++) {

			for (int j = i; j <= 5; j++) {

				System.out.print(" ");

			}

			for (int k = 1; k <= i; k++) {

				System.out.print("* ");

			}

			System.out.println();

		}

	}

	@Test
	public void starPattern() {

		for (int i = 1; i <= 7; i++) {

			for (int j = 1; j <= i; j++) {

				System.out.print("*");

			}

			System.out.print("\n");

		}

	}

}
