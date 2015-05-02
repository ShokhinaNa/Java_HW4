package Pocker;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PokerTests {

	private Card c0;
	private Card c1;
	private Card c2;
	private Card c3;
	private Card c4;
	private String expected;
	
	public PokerTests(Card c0, Card c1, Card c2, Card c3, Card c4, String expected){
		this.c0 = c0;
		this.c1 = c1;
		this.c2 = c2;
		this.c3 = c3;
		this.c4 = c4;
		this.expected = expected;		
	}
	
	@Test
	public void test() {
		final String actual = Poker.hands(c0, c1, c2, c3, c4);
		assertEquals(expected, actual);
	}
	
	@Parameterized.Parameters
	public static List<Object[]> isEmptyData() {
	    return Arrays.asList(new Object[][] {
	    		{new Card(0,0), new Card(1,0), new Card(2,0), new Card(3,0), new Card(0,1), "Four of a kind"},
	    		{new Card(0,0), new Card(1,0), new Card(2,9), new Card(3,9), new Card(0,9), "Full house"},
	    		{new Card(0,0), new Card(1,0), new Card(2,4), new Card(3,5), new Card(0,12), "One pair"},
	    		{new Card(0,0), new Card(1,0), new Card(2,0), new Card(3,5), new Card(0,12), "Three of a kind"},
	    		{new Card(0,0),	new Card(1,0), new Card(2,10), new Card(3,10), new Card(0,4), "Two pair"},
	    		{new Card(0,9), new Card(0,10), new Card(0,11), new Card(0,12), new Card(0,0), "Royal Flush"},
	    		{new Card(0,3), new Card(0,4), new Card(0,5), new Card(0,6), new Card(0,7), "Straight Flush"},
	    		{new Card(0,3), new Card(1,4), new Card(3,5), new Card(2,6), new Card(0,7), "Straight"},
	    		{new Card(0,0), new Card(0,4), new Card(0,12), new Card(0,11), new Card(0,7), "Flush"},
	    		{new Card(2,0), new Card(3,4), new Card(1,12), new Card(0,11), new Card(0,7), "High card"},
	    });
	}
	
}
