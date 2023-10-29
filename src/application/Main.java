package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setMinHeight(500);
			primaryStage.setMinWidth(670);
			
			//load the first FXML file
			Parent root = FXMLLoader.load(getClass().getResource("EffortLoggerLogin.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//load the next FXML file
			FXMLLoader loader = new FXMLLoader(getClass().getResource("EffortLoggerSchedule.fxml"));
			Parent secondRoot = loader.load();
			Scene secondScene = new Scene(secondRoot);
			secondScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}