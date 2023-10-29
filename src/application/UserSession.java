package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserSession {
	public void checkUserID() {
		File readFile = new File("test.txt"); // also had /Users/tuliloapauga/eclipse-workspace/EffortLogger/bin/application/
		if (readFile.exists()) {
			System.out.println("yup");
		}
		try {
			Scanner scanner = new Scanner(readFile);
			while (scanner.hasNextLine()) {
				String data = scanner.nextLine();
				System.out.println(data);
                String name = data.substring(0, 6);
                System.out.println(name);
                String boolCheck = data.substring(7,12);
                System.out.println(boolCheck);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occured");
			e.printStackTrace();
		}
	}
}
