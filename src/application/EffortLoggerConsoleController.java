package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class EffortLoggerConsoleController {
	
	// FXML elements
	@FXML
	Label clockLight;
	
	private Stage stage;
	private Scene scene;
	public boolean activityCheck;
	//private Parent root;
	
	
	public void switchToEditor(ActionEvent e) throws IOException {
		System.out.println("Switching to Editor");
		
		Parent root = FXMLLoader.load(getClass().getResource("EffortLoggerEditor.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void startActivity(ActionEvent e) {
		if (activityCheck) {
			System.out.println("There is already an activity started");
			return;
		}
		System.out.println("Clicked Start an Activity Button");
		clockLight.setStyle("-fx-background-color: green");
		clockLight.setText("Clock is Running");
		activityCheck = true;
	}
	public void stopActivity(ActionEvent e) {
		if (!activityCheck) {
			System.out.println("There is no activity started");
			return;
		}
		System.out.println("Clicked Stop an Activity Button");
		clockLight.setStyle("-fx-background-color: red");
		clockLight.setText("Clock is Stopped");
		activityCheck = false;
	}
}
