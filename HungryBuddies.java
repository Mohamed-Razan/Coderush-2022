package com.coderush2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HungryBuddies {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		String time = scan.nextLine();
		
		double hlp, hls, hlr, hlv, hlk, hlc, ohl;
		hlp = 95; 
		hls = 30;
		hlr = 50;
		hlv = 60;
		hlk = 80;
		hlc = 90;
		
		int wp, ws, wr, wv, wk, wc, i;
		
		wp = Integer.parseInt(String.valueOf(time.charAt(0)));
		ws = Integer.parseInt(String.valueOf(time.charAt(1)));
		wr = Integer.parseInt(String.valueOf(time.charAt(3)));
		wv = Integer.parseInt(String.valueOf(time.charAt(4)));
		wk = Integer.parseInt(String.valueOf(time.charAt(6)));
		wc = Integer.parseInt(String.valueOf(time.charAt(7)));
		
//		System.out.println(wp);
//		System.out.println(ws);
//		System.out.println(wr);
//		System.out.println(wv);
//		System.out.println(wk);
//		System.out.println(wc);
		
		ohl = ((hlp*wp) + (hls*ws) + (hlr*wr) + (hlv*wv) + (hlk*wk) + (hlc*wc))/(wp + ws + wr + wv + wk + wc);
		
//		System.out.println(ohl);
		
		double frhl, frp, khl, kp, rchl, rcp;
		
		List friedRice = new ArrayList<>();
		friedRice.add(20);
		friedRice.add(800);
		friedRice.add(0);
		
		List koththu = new ArrayList<>();
		koththu.add(25);
		koththu.add(950);
		koththu.add(0);
		
		List riceCurry = new ArrayList<>();
		riceCurry.add(15);
		riceCurry.add(300);
		riceCurry.add(0);
		
		Map<String, List> foodMap = new HashMap<>();
		foodMap.put("FRIED_RICE", friedRice);
		foodMap.put("KOTHTHU", koththu);
		foodMap.put("RICE&CURRY", riceCurry);
		
		int totalPrice = 0;
		
	    while(ohl > 0) {
	    	int max =  Math.max(Math.max((int) foodMap.get("FRIED_RICE").get(0), (int) foodMap.get("KOTHTHU").get(0)), (int) foodMap.get("RICE&CURRY").get(0));
		    
		    int price = 100000;
		    String key = "";
		    
		    for (Map.Entry<String, List> entry : foodMap.entrySet()) {
		    	if((int) entry.getValue().get(0) == max) {
		    		if(price > (int) entry.getValue().get(1)) {
		    			price = (int) entry.getValue().get(1);
		    			key = entry.getKey();
		    		}
		    	}
		    }
		    
		    ohl = ohl - (int) foodMap.get(key).get(0);
		    
//		    System.out.println((int) foodMap.get(key).get(2) + 1);
		    
		    int q = (int) foodMap.get(key).get(2) + 1;
		    int hl = (int) foodMap.get(key).get(0) - 5;
		    
		    foodMap.get(key).set(2, q);
		    foodMap.get(key).set(0, hl);
		    
		    totalPrice = totalPrice + (int) foodMap.get(key).get(1);
		    
//		    System.out.println(foodMap);
//		    System.out.println(totalPrice);
//		    System.out.println();
	    }
	    
	    System.out.println("Fried Rice - " + foodMap.get("FRIED_RICE").get(2));
	    System.out.println("Koththu - " + foodMap.get("KOTHTHU").get(2));
	    System.out.println("Rice and Curry - " + foodMap.get("RICE&CURRY").get(2));
	    System.out.println("Total Bill = " + totalPrice);
	    
	    
		
	}

}
