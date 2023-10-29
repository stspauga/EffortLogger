package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserSession {

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
                scanner.close();
			}
		} catch (FileNotFoundException e) {
			System.out.println("An error occured");
			e.printStackTrace();
		}

		System.out.println("hi");
		return false;

	}
}
