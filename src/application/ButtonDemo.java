package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ButtonDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            // Create a BorderPane as the root
            BorderPane root = new BorderPane();

            // Create a button
            Button myButton = new Button("Click me!");

            // Set action for the button
            myButton.setOnAction(e -> System.out.println("Button clicked!"));

            // Set the button as the center of the BorderPane
            root.setCenter(myButton);

            // Create the scene
            Scene scene = new Scene(root, 400, 400);

            // Add CSS styles if needed
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            // hello this is testBranch edit
            // Set the scene and show the stage
            primaryStage.setScene(scene);
            primaryStage.setTitle("Button Demo");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
