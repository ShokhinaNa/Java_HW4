package Pocker;

import java.util.LinkedHashMap;
import java.util.Map;

public class Poker {
	
	public static String hands(Card list0, Card list1, Card list2, Card list3, Card list4){
		//how many times all ranks contained
		Card[] list = new Card[5];
		list[0]=list0;
		list[1]=list1;
		list[2]=list2;
		list[3]=list3;
		list[4]=list4;
		
		Map<Integer, Integer> ranks = new LinkedHashMap<>();
		for (int i = 0; i < 5; i++) {
			if(ranks.get(list[i].getRank()) != null ) {
				ranks.put(list[i].getRank(), ranks.get(list[i].getRank()) + 1);
			} else ranks.put(list[i].getRank(), 1);
		}
			
//		for (int i = 0; i < 12; i++) {
//			System.out.println(i + " " + ranks.get(i));
//		}
		
		//flush
		boolean flag = true;
		for (int i = 0; i < 4; i++) {
			if (list[i].getSuit() != list[i+1].getSuit()) flag=false;
		}
		 
		
			int flag2 = 0; // rank 3 times
			int flag3 = 0; // rank 2 times
			for (Map.Entry<Integer, Integer> ranksEntry: ranks.entrySet()) {
				switch (ranksEntry.getValue()) { 
				case 4 :{
					return "Four of a kind";
					}
				case 3 :{
					flag3++;
					break;
					}
				case 2 :{
					flag2++;
					break;
					}
				case 1 :{
					break;
					}
				}
				
			}
			if (flag2 == 1 && flag3 == 1)  return "Full house";
			if (flag2 == 1)  return "One pair";	
			if (flag3 == 1)  return "Three of a kind";
			if (flag2 == 2)  return "Two pair";
			 
			//Straight
			if (flag2 == 0 && flag3 == 0) {	
				if (ranks.containsKey(12) && ranks.containsKey(11) && ranks.containsKey(10) && ranks.containsKey(9) && ranks.containsKey(0)) {
					if (flag) return "Royal Flush";
					else return "Straight";
				}
				for (int i = 0; i <= 8; i++) {
					if (ranks.containsKey(i) && ranks.containsKey(i+1) && ranks.containsKey(i+2) && ranks.containsKey(i+3) && ranks.containsKey(i+4))
						if (flag) return "Straight Flush";
						else return "Straight";
				}
			}
			
		if (flag) return "Flush";
		return "High card";
	}
	
	
	public static void main(String[] args) {
		
	CardPile pile = new Pile(); 
	
	Card list0=pile.pop();
	Card list1=pile.pop();
	Card list2=pile.pop();
	Card list3=pile.pop();
	Card list4=pile.pop();
	
//	for (int i = 0; i < 5; i++) {
	//	System.out.println("suit: " + list[i].getSuit() + " rank: " + list[i].getRank());
//	}
	
	System.out.println(hands(list0, list1, list2, list3, list4));
	
	}
}
