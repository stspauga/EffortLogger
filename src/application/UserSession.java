package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class UserSession {

	public boolean checkUserID(String userName) {
		userName = userName.toLowerCase();

		String file = "test.txt"; ///Users/tuliloapauga/eclipse-workspace/EffortLogger/src/application
		File readFile = new File(file);
		if (readFile.exists()) {
			System.out.println("yup");
			try {
				Scanner scanner = new Scanner(readFile);
				while (scanner.hasNext()) {
					String data = scanner.nextLine();
					if (data.contains(userName)) {
						if (data.contains("true")) {
							return false;
						}
					}
				}
				scanner.close();
			}
			catch (IOException e) {
				System.out.println("An error occured");
				e.printStackTrace();
			}
		}
		else {
			try {
				File create = new File(file);
				create.createNewFile();
				FileWriter writer = new FileWriter(file);
				writer.write(userName + "true");
				writer.close();
				return true;
			} 
			catch (IOException e) {
				System.out.println("An error occured");
				e.printStackTrace();
			}
		}
		return false;
	}
}
