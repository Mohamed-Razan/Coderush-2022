package com.coderush2022;

import java.util.Scanner;

public class PasswordEncryption {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int i, n;
		n = scan.nextInt();
		int dec[] = new int[n];
		String hex[] = new String[n];
		
		for(i = 0; i < n; i++) {
			dec[i] = scan.nextInt();
			hex[i] = Integer.toHexString(dec[i]);
		}
		
		int sum = 0;
		for(i = 0; i < n; i++) {
			int count= Integer.parseInt(hex[i].replaceAll("[^0-9]", ""));
			sum = sum + count;
		}
		
		System.out.println(sum);
	}

}
