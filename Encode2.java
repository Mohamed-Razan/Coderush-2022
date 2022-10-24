package com.coderush2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Encode2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String o = sc.nextLine();
		String e = sc.nextLine();
		char[] odd = o.toCharArray();
		char[] even = e.toCharArray();
		int len = odd.length;
		
		int i;

		for (i = 0; i < (len / 2); i++) {
			char l = odd[i];
			odd[i] = odd[len - i - 1];
			odd[len - i - 1] = l;
		}
		
		
		int clen = odd.length + even.length;
		char combined[] = new char[clen];
		
		for(i = 0;  i < clen; i++) {
			if(i%2 == 0) {
				combined[i] = even[i/2];
			}
			
			else {
				combined[i] = odd[i/2];
			}
		}
		
		String ans = "";
		
		for(i = 0; i < combined.length; i=i+2) {
			String word = Character.toString(combined[i]) + Character.toString(combined[i+1]);
			
			int decimal=Integer.parseInt(word,16);  
			
			ans = ans + (char) decimal;
			
		}
		
		System.out.println(ans);

	}
}