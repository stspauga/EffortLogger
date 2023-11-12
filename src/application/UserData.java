/* User Data Object
 * This will also be read from a file after user authentication in the end product,  
 * 	but for this prototype, it will only be created upon first sign in.
 * This will be saved to a file upon exiting to login screen or upon exiting in the end product.
 * Contributions :
 * Zachary Weber
 * Madeleinne Tan
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
	
	private EffortCategoryData effortCategory = new EffortCategoryData();
	
	// This constructor will be used in the case of a new user sign in
	// lets the new user input data
	UserData(String firstName, String LastName, String username, String password, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;

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
	 
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public String getPosition() {
		return position;
	}
	public int getID() {
		return userId;
	}
	public String getFileName() {
		return userFileName;
	}
	
	public EffortCategoryData getEffortCategory() {
		return effortCategory;
	}
	
	// set methods for the same variables
	public void setFirstname(String name) {
		firstName = name;
	}
	public void setLastName(String name) {
		lastName = name;
	}
	public void setEmail(String e) {
		email = e;
	}
	public void setUserName(String newName) {
		userName = newName;
	}
	public void setPassword(String newPswrd) {
		// Insert call to Password.java to check the password!!
		boolean lengthCheck = Password.checkLength(newPswrd);
		boolean contentCheck = Password.checkContents(newPswrd);
		
		while((lengthCheck && contentCheck) == false) {
			// in the case the user tries to reset it to an invalid pswrd...
			System.out.println("Please enter a password that has at least 7 characters and the phrase 'TH24'.");
			// alternatively, it can boot them out after 2 incorrect tries? Idk, having 'TH24' here doesn't make the secret phrase so secret anymore XD
		}
		password = newPswrd;
	}
	public void setPosition(String job) {
		position = job;
	}
	public void setID(int id) {
		userId = id;
	}
	public void setFileName(String newIdentity) {
		userFileName = newIdentity;
	}
	
	public ProjectData[] getProjectArr() {
		return projectArr;
	}
}
