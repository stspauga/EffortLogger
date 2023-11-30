package application;

import java.util.ArrayList;

public class AllPokerCards {
	
	private static ArrayList<PokerCard> allCards = new ArrayList<PokerCard>();
	private static PokerCard card1;
	private static PokerCard card2;
	private static PokerCard card3;
	private static PokerCard card4;
	private static PokerCard card5;
	private static PokerCard card6;
	private static PokerCard card7;
	private static PokerCard card8;
	private static PokerCard card9;
	private static PokerCard card10;
	
	//initialize the historical data
	public static void initializeList() 
	{
		card1 = new PokerCard("Employee Privacy", "password-verification", 4, "use duo; ");
		card2 = new PokerCard("Employee Privacy", "password-verification", 3, "password encrypted; ");
		card3 = new PokerCard("Employee Privacy", "color scheme for the app", 0, "change the old theme; ");
		card4 = new PokerCard("Improve website viewer retention", "more customized recommendations", 4, "to increase customer base; ");
		card5 = new PokerCard("Improve website viewer retention", "more customized recommendations", 2, "have done this in the past; ");
		card6 = new PokerCard("Improve website viewer retention", "more customized recommendations", 4, "needs to be done in 1 month; ");
		card7 = new PokerCard("Employee Privacy", "Freedom to change user settings", 4, "deadline: 3 months; ");
		card8 = new PokerCard("Improve website viewer retention", "run ads", 3, "look into brand deals; ");
		card9 = new PokerCard("Improve website viewer retention", "run ads", 5, "have some sponsors available; ");
		card10 = new PokerCard("Improve website viewer retention", "run ads", 0, "customers don't like it; ");
		
		allCards.add(card1);
		allCards.add(card2);
		allCards.add(card3);
		allCards.add(card4);
		allCards.add(card5);
		allCards.add(card6);
		allCards.add(card7);
		allCards.add(card8);
		allCards.add(card9);
		allCards.add(card10);
	}
	
	//getter for allCards
	public static ArrayList<PokerCard> getAllCards()
	{
		return allCards;
	}

	//get a element of allCards
	public static PokerCard getCard(int index)
	{
		return allCards.get(index);
	}
	
	//print all existing cards
	public static void printCards()
	{
		System.out.print("All exisiting planning poker cards");
		for(int i = 0; i < allCards.size(); i++)
		{
			(allCards.get(i)).display();
		}
	}
	
	//add a card to historical data
	public static void addElement(PokerCard p1)
	{
		allCards.add(p1);
	}

}
