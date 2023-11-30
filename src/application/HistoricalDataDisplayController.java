package application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.ArrayList;

public class HistoricalDataDisplayController {
	
	@FXML
	private TextArea criteriaTextArea;
	private Stage stage;
	private Scene scene;
	
	
	@FXML
	Label itemNameLabel;
	@FXML
	Label numberOfInstancesLabel;
	@FXML
	Label averageWeightLabel;
	
	private ArrayList<PokerCard> historicalData;
	private int avgWeight;
	private String userStory = "";
	private String itemName = "";
	private String criteria;
	
	// Method to set values in TextFields
    public void setTextFieldValues(String userStory1, String itemName1) {
    	
    	userStory = userStory1;
    	itemName = itemName1;
    	criteria = "";
    	
    	int weightSum = 0;
    	int instances = 0;
    	historicalData = AllPokerCards.getAllCards();
    	for(PokerCard card : historicalData)
    	{
    		if(card.getUserStory().equals(userStory))
    		{
    			if(card.getItemName().equals(itemName))
    			{
    				instances++;
    				weightSum += card.getWeight();
    				//display the latest criteria
    				criteria = card.getCriteria() + "\n";
    			}
    		}
    	}
    	
    	avgWeight = weightSum/instances;
    	
        // Set values in corresponding TextFields
    	itemNameLabel.setText(itemName);
    	numberOfInstancesLabel.setText(Integer.toString(avgWeight));
    	averageWeightLabel.setText(Integer.toString(avgWeight));
    }
    
    //method to display poker card
    public void displayHistoricalCard(ActionEvent e)
    {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("CardDisplay.fxml"));
			Parent root = loader.load();
			
			CardDisplayController displayController = loader.getController();
			
			displayController.displayCard(userStory, itemName, avgWeight, criteria, e);

			//switch scenes
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
		}
		catch(IOException exception)
		{
			exception.printStackTrace();
		};
    }


}
