package application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PlanningPokerController {
	
	@FXML
	private Stage stage;
	private Scene scene;
	public boolean activityCheck;
	
	//method that helps navigate to a file
	public void switchScreen (String newScreenFile, ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource(newScreenFile));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	//handling event when the project criteria and item weights button is clicked
	public void switchToProjectCriteria(ActionEvent e) throws IOException {
		System.out.println("Switching to Project Criteria and Item Weights");
		String newScreenFile = "ItemWeights.fxml";
		switchScreen(newScreenFile, e);
	}
	
	//handling the event when the planning poker button is clicked
	public void switchToPlanningPokerCards(ActionEvent e) throws IOException {
		System.out.println("Switching to Planning Poker Cards");
		String newScreenFile = "PlanningPokerCards.fxml";
		switchScreen(newScreenFile, e);
	}
	
	//handling the event when the historical data button is clicked
	public void switchToHistoricalData(ActionEvent e) throws IOException {
		System.out.println("Switching to Planning Poker Cards");
		String newScreenFile = "HistoricalData.fxml";
		switchScreen(newScreenFile, e);
	}
}