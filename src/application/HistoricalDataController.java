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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.ArrayList;

public class HistoricalDataController {
	private ArrayList<PokerCard> historicalData = AllPokerCards.getAllCards();
	@FXML
	private ChoiceBox<String> userStoryChoiceBox;
	@FXML
	private ChoiceBox<String> itemNameChoiceBox;
	
	@FXML
	private Stage stage;
	private Scene scene;
	
	public void initialize()
	{
		for(PokerCard pokerCard : historicalData)
		{
			String userStory = pokerCard.getUserStory();
			if(!userStoryChoiceBox.getItems().contains(userStory))
			{
				userStoryChoiceBox.getItems().add(userStory);
			}
		}
		userStoryChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            updateItemNameChoiceBox(newValue);
        });
	}
	
	private void updateItemNameChoiceBox(String selectedUserStory)
	{
		itemNameChoiceBox.getItems().clear();
		 for (PokerCard pokerCard : historicalData) {
			 if (pokerCard.getUserStory().equals(selectedUserStory)) {
				 String itemName = pokerCard.getItemName();
				 if (!itemNameChoiceBox.getItems().contains(itemName)) {
	                    itemNameChoiceBox.getItems().add(itemName);
	                }
			 	}
			 }
	}
	//Switch to the Planning poker scene
	public void switchToPlanningPoker(ActionEvent e) throws IOException {
		System.out.println("Switching to Planning Poker");
		String newScreenFile = "PlanningPoker.fxml";
		switchScreen(newScreenFile, e);
	}
	
	//show historical data
	public void showHistoricalData(ActionEvent e) throws IOException {
		//send values to historical data display
		
		//HistoricalDataDisplayController h1 = new HistoricalDataDisplayController();
		//h1.setTextFieldValues(userStoryChoiceBox.getValue(), itemNameChoiceBox.getValue());
		System.out.println("Switching to Historical Data Display");
		//String newScreenFile = "HistoricalDataDisplay.fxml";
		//switchScreen(newScreenFile, e);
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("HistoricalDataDisplay.fxml"));
			Parent root = loader.load();
			
			HistoricalDataDisplayController displayController = loader.getController();
			
			displayController.setTextFieldValues(userStoryChoiceBox.getValue(), itemNameChoiceBox.getValue());

			//switch scenes
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
		}
		catch(IOException exception)
		{
			exception.printStackTrace();
		}
	}
	
	public void switchScreen (String newScreenFile, ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource(newScreenFile));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
