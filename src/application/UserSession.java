package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class UserSession {
<<<<<<< HEAD

	public boolean checkUserID(String userName) {
		userName = userName.toLowerCase();

		String file = "test.txt";
		File readFile = new File(file);
		if (readFile.exists()) {
			//System.out.println("yup");
			try {
				Scanner scanner = new Scanner(readFile);
				while (scanner.hasNext()) {
					String data = scanner.nextLine();
					if (data.contains(userName)) {
						readFile.delete();
						return false;
					}
				}
				scanner.close();
			}
			catch (IOException e) {
				System.out.println("An error occured");
				e.printStackTrace();
=======
	public boolean checkUserID(String userName) {
		File readFile = new File("/Users/tuliloapauga/eclipse-workspace/EffortLogger/bin/application/test.txt");
		if (readFile.exists()) {
			System.out.println("yup");
		}
		try {
			Scanner scanner = new Scanner(readFile);
			while (scanner.hasNextLine()) {
				String data = scanner.nextLine();
//				System.out.println(data);
				int spaceIndex = data.indexOf(" ");
                String name = data.substring(0, spaceIndex);
                userName = name.toLowerCase();
//                System.out.println("userName is " + userName + "G");
//                System.out.println("name is " + name + "G");
                String boolCheck = data.substring(spaceIndex + 1);
//                System.out.println("G" + boolCheck + "G");
                if (userName.equals(name)) {
                	if (boolCheck.equals("false")) {
                		return true;
                	}
                }
>>>>>>> 298cb2e (Updated UserSession)
			}
		}
<<<<<<< HEAD
		else {
			try {
				File create = new File(file);
				create.createNewFile();
				FileWriter writer = new FileWriter(file);
				writer.write(userName);
				writer.close();
				return true;
			} 
			catch (IOException e) {
				System.out.println("An error occured");
				e.printStackTrace();
			}
		}
=======
		System.out.println("hi");
>>>>>>> 298cb2e (Updated UserSession)
		return false;
	}
}
