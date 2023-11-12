/* Controller Class for the Effort Logger Definitions Scene
 * Contributions :
 * Zachary Weber
*/
package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EffortLoggerDefinitionsController {
		
	private Stage stage;
	private Scene scene;
	private List<Definition> definition_list = new ArrayList<>();
	
	@FXML
	private TextField proj_name;
	@FXML
	private TextField details;
	@FXML
	private TextField life_cycle;
	@FXML
	private TextArea proj_name_disp;
	@FXML
	private TextArea det_disp;
	@FXML
	private TextArea life_cycle_disp;

	
	// Switch to the Effort Logger Console
	public void switchToConsole(ActionEvent e) throws IOException {
		System.out.println("Switching to Console");
		
		Parent root = FXMLLoader.load(getClass().getResource("EffortLoggerConsole.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void addProject(ActionEvent e) throws IOException {
		Definition newDef = new Definition();
		definition_list.add(newDef.setDefinitionItem(proj_name.getText(), details.getText(), life_cycle.getText()));
		proj_name.clear();
		details.clear();
		life_cycle.clear();
		displayProject(e);
	}
	
	public void displayProject(ActionEvent e) throws IOException {
	    StringBuilder projNames = new StringBuilder();
	    StringBuilder detailsText = new StringBuilder();
	    StringBuilder lifeCycleText = new StringBuilder();
	    
	    for (int i = 0; i < definition_list.size(); i++) {
	        projNames.append(definition_list.get(i).getPROJ_NAME()).append("\n");
	        detailsText.append(definition_list.get(i).getDETAILS()).append("\n");
	        lifeCycleText.append(definition_list.get(i).getLIFE_CYCLE()).append("\n");
	    }

	    proj_name_disp.setText(projNames.toString());
	    det_disp.setText(detailsText.toString());
	    life_cycle_disp.setText(lifeCycleText.toString());
	}
	
	public void searchProjects(ActionEvent e) throws IOException {
		
	}

}