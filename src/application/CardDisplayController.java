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
		loadNewFile(e);
		
	}
	
	private void loadNewFile(ActionEvent e)
	{
		try {
			Parent root = FXMLLoader.load(getClass().getResource("CardDisplay.fxml"));
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
}
