package application;

import java.util.ArrayList;

public class AllPokerCards {
	
	public static ArrayList<PokerCard> allCards = new ArrayList<PokerCard>();
	// this ^^ was originally PRIVATE
	private static PokerCard card1;
	private static PokerCard card2;
	private static PokerCard card3;
	private static PokerCard card4;
	private static PokerCard card5;
	private static PokerCard card6;
	
	public static void initializeList() {
		card1 = new PokerCard("Employee Privacy", "password-verification", 4, "use duo");
		card2 = new PokerCard("Employee Privacy", "password-verification", 3, "password encrypted");
		card3 = new PokerCard("Employee Privacy", "color scheme for the app", 0, "change the old theme");
		card4 = new PokerCard("Improve website viewer retention", "more customized reccomendations", 4, "to increase customer base");
		card5 = new PokerCard("Improve website viewer retention", "more customized reccomendations", 2, "have done this in the past; didn't work");
		card6 = new PokerCard("Improve website viewer retention", "more customized reccomendations", 4, "");
		
		allCards.add(card1);
		allCards.add(card2);
		allCards.add(card3);
		allCards.add(card4);
		allCards.add(card5);
		allCards.add(card6);
		
	}
	
	//getter for allCards
	public static ArrayList<PokerCard> getAllCards(){
		return allCards;
	}
	
	//get an element of allCards
	public static PokerCard getCard(int index) {
		return allCards.get(index);
	}
	
	//print all existing cards
	public static void printCards() {
		System.out.println("All existing planning poker cards");
		for(int i=0; i<allCards.size(); i++) {
			(allCards.get(i)).display();
		}
	}
	
	//add a card to historical data
	public static void addElement(PokerCard p1)
	{
		allCards.add(p1);
	}

}
