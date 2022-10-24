package com.coderush2022;

import java.util.Scanner;

public class Encode3 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		String name, dob, first;
		int second, third;
		
		name = scan.nextLine();
		dob = scan.nextLine();
		
		if(name.charAt(0) < 'A' || name.charAt(0) > 'Z') {
			System.out.println("Input only Capital Letters for 1st character");
		}
		
		else {
			first = dob.substring(0, 2);
			String dobSplitted[] = dob.split("-");
			second = Integer.parseInt(dobSplitted[1]) + Integer.parseInt(dobSplitted[2]);
			third = (int) name.charAt(0) + (int) name.charAt(name.length() - 1);
			
			System.out.print(first);
			
			if(second >= 10) {
				System.out.print(second);
			}
			
			else {
				System.out.print("0" + Integer.toString(second));
			}
			
			if(third < 100) {
				System.out.print("0" + Integer.toString(third));
			}
			
			else {
				System.out.println(third);
			}
		}
	}

}
