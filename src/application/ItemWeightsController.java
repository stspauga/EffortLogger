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
	@FXML
	private CardDisplayController cardDisplayController;


	
	@FXML
	private void generateCard(ActionEvent e) throws IOException
	{
		String userStory = userStoryTextField.getText();
		String itemName = itemNameTextField.getText();
		String criteria = criteriaTextArea.getText();
		int assignedWeight = getSelectedButton();
		
		//calling display card method
		cardDisplayController.displayCard(userStory, itemName, assignedWeight, criteria, e);
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
}
