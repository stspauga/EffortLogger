package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class UserSession {

	public boolean checkUserID(String userName) {
		userName = userName.toLowerCase();
<<<<<<< HEAD

		String file = "test.txt";
		File readFile = new File(file);
		if (readFile.exists()) {
			//System.out.println("yup");
=======
		String file = "/Users/tuliloapauga/eclipse-workspace/EffortLogger/src/application/test.txt";
		File readFile = new File(file);
		if (readFile.exists()) {
			System.out.println("yup");
>>>>>>> 78ad9bc (Finished prototype)
			try {
				Scanner scanner = new Scanner(readFile);
				while (scanner.hasNext()) {
					String data = scanner.nextLine();
					if (data.contains(userName)) {
<<<<<<< HEAD
						readFile.delete();
						return false;
=======
						if (data.contains("true")) {
							return false;
						}
>>>>>>> 78ad9bc (Finished prototype)
					}
				}
				scanner.close();
			}
			catch (IOException e) {
				System.out.println("An error occured");
				e.printStackTrace();
<<<<<<< HEAD
=======
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
>>>>>>> 78ad9bc (Finished prototype)
			}
		}
		return false;
	}
}
