package application;

import java.util.ArrayList;

public class AllPokerCards {
	
	private static ArrayList<PokerCard> allCards = new ArrayList<PokerCard>();
	
	
	public static void printCards()
	{
		System.out.print("All exisiting planning poker cards");
		for(int i = 0; i < allCards.size(); i++)
		{
			(allCards.get(i)).display();
		}
	}
	
	public static void addElement(PokerCard p1)
	{
		allCards.add(p1);
	}

}
