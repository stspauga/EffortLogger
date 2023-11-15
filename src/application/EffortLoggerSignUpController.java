/* Controller Class for the Effort Logger Login screen
 * Contributions :
 * Zachary Weber
 * Sindhu Rallabhandi
 * Madeleinne Tan
 * Nghiem Nguyen
 * Thai Nguyen
*/
package application;

import java.io.IOException;
import java.io.*;
import java.util.Base64;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EffortLoggerSignUpController {
	private Stage stage;
	private Scene scene;
	//private Parent root;
	

	// FXML elements
	@FXML
	private PasswordField passwordField;
	private Password checker;
	@FXML 
	private TextField usernameField;
	private InputValidation inputValidation;
	@FXML
	private TextField userFirstName;
	@FXML
	private TextField userLastName;
	@FXML
	private TextField userRole;
	@FXML
	private TextField userPhoneNumbers;

	//create a class of user for the user's information
	class User {
		String firstName;
		String lastName;
		String role;
		String phoneNumbers;
		String username;
		String password;

		//constructor
		public User(String firstName, String lastName, String role, String phoneNumbers, String username, String password) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.role = role;
			this.phoneNumbers = phoneNumbers;
			this.username = username;
			this.password = password;
		}

		//getters
		public String getFirstName() {
			return firstName;
		}
		
		public String getLastName() {
			return lastName;
		}

		public String getRole() {
			return role;
		}

		public String getPhoneNumbers() {
			return phoneNumbers;
		}

		public String getUsername() {
			return username;
		}

		public String getPassword() {
			return password;
		}

		//setters
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public void setPhoneNumbers(String phoneNumbers) {
			this.phoneNumbers = phoneNumbers;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	}
	
	public void SignUp(ActionEvent e) throws IOException {
		
		//Insert first name into text field
		String enteredFirstName = userFirstName.getText();
		
		//Insert last name into text field
		String enteredLastName = userLastName.getText();

		//Insert role into text field
		String enteredRole = userRole.getText();
		
		//Insert phone numbers into text field
		String enteredPhoneNumbers = userPhoneNumbers.getText();
			
		//checking if user name is valid
		String enteredUsername = usernameField.getText();
		inputValidation = new InputValidation(enteredUsername);
	
		boolean validUsername = inputValidation.isValidInput(enteredUsername);
		boolean validEmail = inputValidation.isValidEmail(enteredUsername);
		
	
		boolean acceptedUser = validUsername || validEmail;
		if(!(acceptedUser))
		{
			System.out.println("Wrong Username - should be valid email or username with letters, numbers, \"-\", or \"_\"");
		}
		
		
		//checking if password is right
	
		String enteredPassword = passwordField.getText();
	    checker = new Password(enteredPassword);
	    boolean contentsPass = checker.checkContents(enteredPassword);
	    
	    // broken down for debugging purposes
	    if(contentsPass) {
	    	System.out.println("contents passed");
	    }
	    boolean lengthPass = checker.checkLength(enteredPassword);
	    if(lengthPass) {
	    	System.out.println("length passed");
	    }
	    boolean accepted = contentsPass && lengthPass;
	
	
	    //if password and user name are valid
		if (accepted && acceptedUser) {
	
			//write user's information to database
			User newUser = new User(enteredFirstName, enteredLastName, enteredRole, enteredPhoneNumbers, enteredUsername, enteredPassword);
        	writeUserToFile(newUser, "userDatabase.txt");
			
			//Navigate back to the login page
        	Parent root = FXMLLoader.load(getClass().getResource("EffortLoggerLogin.fxml"));
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
		}
	
		else {
			System.out.println("Wrong password");
		}
	}
	
	private void clearFields() {
	    userFirstName.setText("");
	    userLastName.setText("");
	    userRole.setText("");
	    userPhoneNumbers.setText("");
	    usernameField.setText("");
	    passwordField.setText("");
	}
	
	//write user's information to database
	private void writeUserToFile(User user, String filename) {
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)))) {
			
			out.println("First Name: " + user.getFirstName());
			out.println("Last Name: " + user.getLastName());
			out.println("Phone Numbers: " + user.getPhoneNumbers());
			out.println("Role: " + user.getRole());
			out.println("Username/email: " + user.getUsername());

			// Encode the password
	        String encodedPassword = Base64.getEncoder().encodeToString(user.getPassword().getBytes());
	        out.println("Password: " + encodedPassword);
	        out.print("\n");
	        
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	//put it on the return button in sign up page
	public void switchToLogin(Stage stage) throws IOException {
		System.out.println("Switching to Login Page");
		Parent root = FXMLLoader.load(getClass().getResource("EffortLoggerLogin.fxml"));
		//stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }
	
	public void LogIn(ActionEvent e) throws IOException {
		System.out.println("Switching to Login page");
		Parent root = FXMLLoader.load(getClass().getResource("EffortLoggerLogin.fxml"));
	    stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void resetField(ActionEvent e) throws IOException {
		clearFields();
	}
}