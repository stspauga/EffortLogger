/* User Data Object
 * This will also be read from a file after user authentication in the end product,  
 * 	but for this prototype, it will only be created upon first sign in.
 * This will be saved to a file upon exiting to login screen or upon exiting in the end product.
 * Contributions :
 * Zachary Weber
 * Madeleinne Tan
*/
package application;

import java.util.ArrayList;

public class UserData {
	// Personal User Data
	private String displayName;
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
	
	// Effort Category Information
	private ArrayList<String[]> effortDefinitions = new ArrayList<String[]>();
	
	// This constructor will be used in the case of a new user sign in
	// lets the new user input data

	UserData(String dispName, String firstName, String lastName, String userName, String password, String email) {
		this.displayName = dispName;
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
		this.displayName = "Singer1";
		this.firstName = "Michael";
		this.lastName = "Jackson";
		this.userName = "MJackson";
		this.password = "kingofTH24";
		this.email = "mj@gmail.com";
		// default demo project
		projectArr[0] = new ProjectData();
		projectArr[1] = new ProjectData();
		projectArr[1].setName("Other Project");
		
		//Effort Categories default setup
		// 0th element is the title
		// 1st-Xth elements are the definitions
		String[] plans = new String[] 
				{"Plans", "Project", "Risk Management", "Conceptual Design", "Detailed Design", 
				"Implementation", "", "", "", "", ""};
		effortDefinitions.add(plans);
		String[] deliverables = new String[] 
				{"Deliverables", "Conceptual Design","Detailed design","Test Cases","Solution","Reflection",
				"Outline","Draft","Report","User Defined","Other"};
		effortDefinitions.add(deliverables);
		String[] interruptions = new String[] 
				{"Interruptions", "Break","Phone","Teammate","Visitor","Other","","","","",""};
		effortDefinitions.add(interruptions);
		String[] defectCategories = new String[] 
				{"Defects"};
		String[] other = new String[] {"Others"};
		effortDefinitions.add(other);
		
	}
	
	// This constructor will be used in the future to initialize UserData from a given file
	// 	that is found upon authentication
	UserData(String userFileName) {
		// TO-DO---------------------
		return;
	}
	public String getDisplayName() {
		return displayName;
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
	
	public ArrayList<String[]> getEffortDefinitions() {
		return effortDefinitions;
	}
	
	public String[] getEffortTypeDefinition(String category) {
		String[] list;
		int i = 0;
		while (i < effortDefinitions.size()) {
			if (effortDefinitions.get(i)[0].compareTo(category) == 0) {
				list = new String[effortDefinitions.get(i).length - 1];
				for (int j = 0; j < list.length; j++) {
					if (list[j] != "") {
						list[j] = effortDefinitions.get(i)[j + 1];
					}
				}
				return list;
			}
			i++;
		}
		//else return empty
		list = new String[] {""};
		return list;
	}
	
	// set methods for the same variables
	public void setDisplayName(String name) {
		displayName = name;
	}
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
