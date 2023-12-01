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
import javafx.scene.control.*;

public class CardDisplayController {
	
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
	
	public void displayCard(String userStory, String itemName, int weight, String criteria, ActionEvent e)
	{
		itemNameLabel.setText(itemName);
		userStoryLabel.setText(userStory);
		assignedWeightLabel.setText(Integer.toString(weight));
		criteriaTextArea.setText(criteria);
	}
	
	//switch to console
	public void switchToConsole(ActionEvent e) throws IOException {
		System.out.println("Switching to Console");
		Parent root = FXMLLoader.load(getClass().getResource("EffortLoggerConsole.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	//Switch to the Planning poker scene
	public void switchToPlanningPoker(ActionEvent e) throws IOException {
		System.out.println("Switching to Planning Poker");
		String newScreenFile = "PlanningPoker.fxml";
		switchScreen(newScreenFile, e);
	}
	
	
	public void switchScreen (String newScreenFile, ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource(newScreenFile));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
