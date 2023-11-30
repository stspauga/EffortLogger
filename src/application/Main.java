package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
//import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextField;


public class Main extends Application {
	
	// --------------------------------------------- New thing in Main -> Main.getUserData().doWhatever
	public static UserData userData;
	public static UserSession userSession = new UserSession();
	@FXML
	private TextField usernameField;
	
//	private static ClockManager clockManager;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setMinHeight(500);
			primaryStage.setMinWidth(670);
			Parent root = FXMLLoader.load(getClass().getResource("EffortLoggerLogin.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		launch(args);
	}

	
	
	public void stop() throws IOException{
		System.out.println(userSession.currUser);
		userSession.checkUser();
	}
	
	// For each scene to access User's Data
	public static UserData getUserData() {
		return userData;
	}
	// Set data for a new user
	// Need to implement reading/writing to a file for returning users next phase
	public static void setNewUserData() {
		userData = new UserData();
	}
}