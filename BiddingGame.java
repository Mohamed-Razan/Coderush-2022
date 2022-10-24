package com.coderush2022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BiddingGame {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int i, n;
		n = scan.nextInt();
		scan.nextLine();
		String str = scan.nextLine();

		String names[] = str.split(" ");
		
//		for(i = 0; i < n; i++) {
//			System.out.println(names[i]);
//		}

		String time = scan.nextLine();
		String bidding[] = new String[n];
		Bid bids[] = new Bid[n];

		for (i = 0; i < n; i++) {
			bidding[i] = scan.nextLine();
			String biddingArr[] = bidding[i].split(" ");
			Bid bid = new Bid();
			bid.name = biddingArr[0];
			bid.cardNo = Integer.parseInt(biddingArr[1]);
			bid.price = Integer.parseInt(biddingArr[2]);
			bids[i] = bid;
		}

		String timeSplitted[] = time.split(" ")[0].split(":");

		int h = Integer.parseInt(timeSplitted[0]);
		int m = Integer.parseInt(timeSplitted[1]);
		int s = Integer.parseInt(timeSplitted[2]);

//		System.out.println(h + " " + m + " " + s);

		int x = h % n + 2;

//		System.out.println(x);

		int win = (m + s) % x + 1;

//		System.out.println(win);

		List<Bid> winBid = new ArrayList<>();
		int totMoney = 0;
		int winMoney = 0;

		for (i = 0; i < n; i++) {
			totMoney = totMoney + bids[i].price;

			if (bids[i].cardNo == win) {
				winBid.add(bids[i]);
				winMoney = winMoney + winBid.get(i).price;
			}
		}

//		System.out.println(totMoney);
//		System.out.println(winMoney);

		System.out.println(win);
		Map<Integer, Integer> winMap = new HashMap<>();

		boolean isWin = false;
		for (i = 0; i < n; i++) {
			if (bids[i].cardNo == win) {
//				System.out.println(names[i] + " " + (int) (((double) bids[i].price / (double) winMoney) * 100) + "% "
//						+ (int) (((double) bids[i].price / (double) winMoney) * totMoney));
				isWin = true;
//				System.out.println(bids[i].price);
				winMap.put(i, (int) (((double) bids[i].price / (double) winMoney) * 100));
			}
		}
		
		Map<Integer, Integer> sortedMap = 
			     winMap.entrySet().stream()
			    .sorted(Entry.comparingByValue())
			    .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
			                              (e1, e2) -> e1, LinkedHashMap::new));
		
		for (i = 0; i < sortedMap.size(); i++) {
			if (bids[i].cardNo == win) {
//				System.out.println(names[sortedMap.get] + " " + (int) (((double) bids[i].price / (double) winMoney) * 100) + "% "
//						+ (int) (((double) bids[i].price / (double) winMoney) * totMoney));
				System.out.println(sortedMap);
				
			}
		}
		
		if(!isWin) {
			System.out.println("Table keeper wins");
		}
	}

}

class Bid {
	String name;
	int cardNo;
	int price;
}
