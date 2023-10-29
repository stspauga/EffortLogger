/* User Data Object
 * This will also be read from a file after user authentication in the end product,  
 * 	but for this prototype, it will only be created upon first sign in.
 * This will be saved to a file upon exiting to login screen or upon exiting in the end product.
 * Contributions :
 * Zachary Weber
*/
package application;

public class UserData {
	// Personal User Data
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String position;
	private String email;
	private int userId;
	private String userFileName;
	//~~~~~Data Structure~~~~~
	// 10 Projects -> 1 User
	private ProjectData[] projectArr = new ProjectData[10];
	
	// Functionality
	public boolean tutor = false;
	
	// This constructor will be used in the case of a new user sign in
	// lets the new user input data
	UserData(String firstName, String LastName, String username, String password, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		tutor = true;
		// default demo project
		projectArr[0] = new ProjectData();
	}
	// Default constructor for tests and prototypes
	UserData() {
		this.firstName = "Michael";
		this.lastName = "Jackson";
		this.userName = "MJackson";
		this.password = "kingofTH24";
		this.email = "mj@gmail.com";
		// default demo project
		projectArr[0] = new ProjectData();
	}
	
	// This constructor will be used in the future to initialize UserData from a given file
	// 	that is found upon authentication
	UserData(String userFileName) {
		// TO-DO---------------------
		return;
	}
}
