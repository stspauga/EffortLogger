// Controller class for PlanningPokerCards.fxml
// Written by Madeleinne Tan

package application;
import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class PlanningPokerCardController {
 	@FXML
    private Label assignedWeightLabel;
    @FXML
    private Label assignedWeightLabel1;
    @FXML
    private Label assignedWeightLabel2;
    @FXML
    private Label assignedWeightLabel3;
    @FXML
    private Label assignedWeightLabel4;
    @FXML
    private Label assignedWeightLabel5;
    @FXML
    private Pane cardFive;
    @FXML
    private Pane cardFour;
    @FXML
    private Pane cardOne;
    @FXML
    private Pane cardSix;
    @FXML
    private Pane cardThree;
    @FXML
    private Pane cardTwo;
    @FXML
    private Label itemNameLabel;
    @FXML
    private Label itemNameLabel1;
    @FXML
    private Label itemNameLabel2;
    @FXML
    private Label itemNameLabel3;
    @FXML
    private Label itemNameLabel4;
    @FXML
    private Label itemNameLabel5;
    @FXML
    private Button returnToPlanPokHome;
	
	private static PokerCard card1;
	private static PokerCard card2;
	private static PokerCard card3;
	private static PokerCard card4;
	private static PokerCard card5;
	private static PokerCard card6;

	@FXML
	private Stage stage;
	private Scene scene;
	public boolean activityCheck;
	
	
	// get the last 6 cards in the array (from most recent to least recent)
	public static void getRecentCards() {
		ArrayList<PokerCard> allCards = new ArrayList<PokerCard>();
		card1 = allCards.get(allCards.size()-1);
		card2 = allCards.get(allCards.size()-2);
		card3 = allCards.get(allCards.size()-3);
		card4 = allCards.get(allCards.size()-4);
		card5 = allCards.get(allCards.size()-5);
		card6 = allCards.get(allCards.size()-6);
	}
	
	// DISPLAY CARDS WITH APPROPRIATE TITLES - INSPIRED BY CARDDISPLAYCONTROLLER.JAVA
	public void displayCards(ActionEvent e)
	{
		itemNameLabel.setText(card1.getItemName());
		assignedWeightLabel.setText(Integer.toString(card1.getWeight()));
		
		itemNameLabel1.setText(card2.getItemName());
		assignedWeightLabel1.setText(Integer.toString(card2.getWeight()));
		
		itemNameLabel2.setText(card3.getItemName());
		assignedWeightLabel2.setText(Integer.toString(card3.getWeight()));
		
		itemNameLabel3.setText(card4.getItemName());
		assignedWeightLabel3.setText(Integer.toString(card4.getWeight()));
		
		itemNameLabel4.setText(card5.getItemName());
		assignedWeightLabel4.setText(Integer.toString(card5.getWeight()));
		
		itemNameLabel5.setText(card6.getItemName());
		assignedWeightLabel5.setText(Integer.toString(card6.getWeight()));
	}
	
	//method that helps navigate to a file
	public void switchScreen (String newScreenFile, ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource(newScreenFile));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	//handling the event when the planning poker button is clicked
	public void switchToPlanningPokerConsole(ActionEvent e) throws IOException {
		System.out.println("Switching to Planning Poker Console");
		String newScreenFile = "PlanningPoker.fxml";
		switchScreen(newScreenFile, e);
	}
	
	//handling the event when a card is clicked
	// FIX THIS SO THAT IT SWITCHES FOR EACH CARD
	public void switchToCard(ActionEvent e)throws IOException{
		System.out.println("Switching to a Card Display");
		String newScreenFile = "CardDisplay.fxml";
		switchScreen(newScreenFile, e);
	}
}
