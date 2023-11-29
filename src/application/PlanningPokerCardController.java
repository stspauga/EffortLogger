// Controller class for PlanningPokerCards.fxml
// Written by Madeleinne Tan

package application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class PlanningPokerCardController {
	@FXML
	private Label userStoryLabel;
	@FXML
	private Label itemNameLabel;
	@FXML
	private Label assignedWeightLabel;
	@FXML
	private TextArea criteriaTextArea;
	@FXML
	private Stage stage;
	private Scene scene;
	public boolean activityCheck;
	
	// DISPLAY CARDS WITH APPROPRIATE TITLES - INSPIRED BY CARDDISPLAYCONTROLLER.JAVA
	public void displayCard(String userStory, String itemName, int weight, String criteria, ActionEvent e)
	{
		itemNameLabel.setText(itemName);
		userStoryLabel.setText(userStory);
		assignedWeightLabel.setText(Integer.toString(weight));
		criteriaTextArea.setText(criteria);
	}
	
	//method that helps navigate to a file
		public void switchScreen (String newScreenFile, ActionEvent e) throws IOException{
			Parent root = FXMLLoader.load(getClass().getResource(newScreenFile));
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	//handling the event when the planning poker button is clicked
	public void switchToPlanningPokerConsole(ActionEvent e) throws IOException {
		System.out.println("Switching to Planning Poker Console");
		String newScreenFile = "PlanningPoker.fxml";
		switchScreen(newScreenFile, e);
	}
	
	//handling the event when a card is clicked
	// FIX THIS SO THAT IT SWITCHES FOR EACH CARD
	public void switchToCard(ActionEvent e)throws IOException{
		System.out.println("Switching to a Card Display");
		String newScreenFile = "CardDisplay.fxml";
		switchScreen(newScreenFile, e);
	}
}
