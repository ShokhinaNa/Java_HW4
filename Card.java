package Pocker;

public class Card {

	private int rank;
	private int suit;
	
	Card link;
	
	Card(final int suitValue, final int rankValue) {
		suit = suitValue;
		rank = rankValue;
	}
	

	public int getRank() {
		return rank;
	}

	public int getSuit() {
		return suit;
	}
	
}
