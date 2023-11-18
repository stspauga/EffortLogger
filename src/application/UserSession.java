package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.io.FileWriter;
import java.io.IOException;

public class UserSession {

	
	public String currUser;
	public Boolean valid;

	public UserSession() {
		this.currUser = "";
		this.valid = true;
	}

	public void setUserName(String userName) {
		this.currUser = userName;
	}
	
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	
	public Boolean getUserSessionCheck() {
		return this.valid;
	}
	
	public void logAUserIn(String currUser) throws IOException {
        File userSeshFile = new File("UserSession.txt");
        StringBuilder buffer = new StringBuilder();
        try (Scanner sc = new Scanner(userSeshFile)) {
            while (sc.hasNextLine()) {
            	String line = sc.nextLine();
                if (line.contains(currUser)) {
                    if (line.indexOf('0') != -1) {
                    	setValid(true);
                    	line = line.replace("0", "1");
                    } else {
                    	setValid(false);
                    }
                }
                buffer.append(line).append(System.lineSeparator());
            }
            try (FileWriter writer = new FileWriter("UserSession.txt")) {
                writer.write(buffer.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
	}
	
	public void checkUser() throws IOException {
        File userSeshFile = new File("UserSession.txt");
        StringBuilder buffer = new StringBuilder();
        try (Scanner sc = new Scanner(userSeshFile)) {
            while (sc.hasNextLine()) {
            	String line = sc.nextLine();
                if (line.contains(currUser)) {
                    if (line.indexOf('1') != -1) {
                    	setValid(true);
                    	line = line.replace("1", "0");
                    }
                }
                buffer.append(line).append(System.lineSeparator());
            }
            try (FileWriter writer = new FileWriter("UserSession.txt")) {
                writer.write(buffer.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
	}
}


