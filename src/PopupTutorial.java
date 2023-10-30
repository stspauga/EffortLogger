/* Part of the Tutorial UI Prototype for new users to reference
 * Creates a pop up window given a message string input
 * Contributions :
 * Zachary Weber
*/
package src;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PopupTutorial {
	private String message;
	public Stage tutorialWindow; 
	PopupTutorial(String message) {
		this.message = message;
	}
	public void displayTutorial() {
		// Create elements
		tutorialWindow = new Stage();
		tutorialWindow.setMinHeight(200);
		tutorialWindow.setMinWidth(350);
		tutorialWindow.setMaxHeight(200);
		tutorialWindow.setMaxWidth(350);
		VBox vBox = new VBox();
		vBox.setAlignment(Pos.CENTER);
		Button okButton = new Button("Okay");
		okButton.setOnAction(e -> closeTutorial());
		Label messageLabel = new Label(message);
		messageLabel.setStyle(message);
		// Add elements to scene
		vBox.getChildren().addAll(messageLabel, okButton);
		Scene scene = new Scene(vBox, tutorialWindow.getMinHeight(), tutorialWindow.getMinWidth());
		
		
		tutorialWindow.setScene(scene);
		tutorialWindow.show();
		
	}
	
	public void closeTutorial() {
		System.out.println("Closing tutorial popup");
		tutorialWindow.close();
	}
}
