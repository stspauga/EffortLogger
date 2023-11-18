
package application;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SettingsConsoleController {
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Text SettingsHeader;
    @FXML
    private Text addressQ;
    @FXML
    private CheckBox checkBoxConsent;
    @FXML
    private Text cityQ;
    @FXML
    private Text displayNameQ;
    @FXML
    private Text firstNameQ;
    @FXML
    private Text lastNameQ;
    @FXML
    private Text phoneNoQ;
    @FXML
    private Button returnHomeButton;
    @FXML
    private Text stateQ;
    @FXML
    private TextField textFieldDisplayName;
    @FXML
    private TextField tfAddress;
    @FXML
    private TextField tfCity;
    @FXML
    private TextField tfFirstName;
    @FXML
    private TextField tfLastName;
    @FXML
    private TextField tfPhoneNo;
    @FXML
    private TextField tfState;
    @FXML
    private TextField tfZip;
    @FXML
    private Text zipQ;

    public void switchScreen (String newScreenFile, ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource(newScreenFile));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
  	
    @FXML
    public void switchToEffortLogConsole(ActionEvent event) throws IOException{
  		System.out.println("Switching to Console");
		Parent root = FXMLLoader.load(getClass().getResource("EffortLoggerConsole.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }
    
  	//get user data from settings, store them in UserData.java
  	//UserData(String firstName, String LastName, String username, String password, String email)
  	public void collectUserData(ActionEvent e) throws IOException{
  		String firstName = tfFirstName.getText();
  		String lastName = tfLastName.getText();
  		String displayName = textFieldDisplayName.getText();
  		String address = tfAddress.getText();
  		String city = tfCity.getText();
  		String state = tfState.getText();
  		String zip = tfZip.getText();
  		
  		
  	}
}
