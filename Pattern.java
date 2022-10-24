package com.coderush2022;

import java.util.Scanner;

public class Pattern {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int n, i, j, k;
		n = scan.nextInt();

		for (i = 0; i <= n; i++) {
			int alphabet = 65;
			for (j = 5; j > i; j--) {
				System.out.print(" ");
			}
			for (k = 0; k <= i; k++) {
				System.out.print((char) (alphabet + i) + " ");
			}
			System.out.println();
		}
	}

}
