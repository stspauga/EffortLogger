package application;

import java.util.ArrayList;

public class PokerCard {
	
	private String userStory;
	private String itemName;
	private int weight;
	private String criteria;
	
	
	
	public PokerCard(String userStory, String itemName, int weight, String criteria)
	{
		this.userStory = userStory;
		this.itemName = itemName;
		this.weight = weight;
		this.criteria = criteria;
	}
	
	
	public void display()
	{
		System.out.println("User Story: " + userStory);
		System.out.println("Item Name: " + itemName);
		System.out.println("Assigned Weight: " + weight);
		System.out.println("Criteria: " + criteria);
	}
	
	public String getUserStory()
	{
		return this.userStory;
	}
	
	public String getItemName()
	{
		return this.itemName;
	}
	
	public int getWeight()
	{
		return this.weight;
	}
	
	public String getCriteria()
	{
		return this.criteria;
	}
}
