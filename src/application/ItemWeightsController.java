package application;
import java.io.IOException;
import java.util.Arrays;

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

public class ItemWeightsController {
	
	@FXML
	private RadioButton radioButton0;
	@FXML
	private RadioButton radioButton1;
	@FXML
	private RadioButton radioButton2;
	@FXML
	private RadioButton radioButton3;
	@FXML
	private RadioButton radioButton4;
	@FXML
	private TextField itemNameTextField;
	@FXML
	private TextField userStoryTextField;
	@FXML
	private TextArea criteriaTextArea;
	private Stage stage;
	private Scene scene;
	private CardDisplayController cardDisplayController;
	
	private String userStory;
	private String itemName;
	private String criteria;
	private int assignedWeight;
	private InputValidation inputValidation;

	
	@FXML
	private void generateCard(ActionEvent e) throws IOException
	{
		
		userStory = userStoryTextField.getText();
		itemName = itemNameTextField.getText();
		criteria = criteriaTextArea.getText();
		assignedWeight = getSelectedButton();
		
		//creating a poker card
		PokerCard card = new PokerCard(userStory, itemName, assignedWeight, criteria);
		//adding the poker card to the existing data
		AllPokerCards.addElement(card);
		loadNewFile(e);
	}
	
	private int getSelectedButton()
	{
		for(RadioButton radioButton : Arrays.asList(radioButton0, radioButton1, radioButton2, radioButton3, radioButton4)){
	        if (radioButton.isSelected()) {
	            return Integer.parseInt(radioButton.getText());
	        }
		}
		return 0;
	}
	
	private void loadNewFile(ActionEvent e)
	{
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("CardDisplay.fxml"));
			Parent root = loader.load();
			
			CardDisplayController displayController = loader.getController();
			
			displayController.displayCard(userStory, itemName, assignedWeight, criteria, e);

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
	
	//switch to console
		public void switchToConsole(ActionEvent e) throws IOException {
			System.out.println("Switching to Console");
			
			Parent root = FXMLLoader.load(getClass().getResource("EffortLoggerConsole.fxml"));
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
}
