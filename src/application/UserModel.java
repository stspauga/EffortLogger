package application;

public class UserModel {
	/*String firstName;
	String lastName;
	String email;
	String password;
	UserModel[] users = new UserModel[7];*/
	int numberOfUsers;
	static User[] users;
	
	/*public UserModel() {
		firstName = "";
		lastName = "";
		email = "";
		password = "";
	}*/
	
	//constructor
	public UserModel(int number)
	{
		numberOfUsers = number;
		users = new User[numberOfUsers];
	}
	
	
	public void createTestUser(int index, String firstName, String lastName, String email, String password) {
		
		InputValidation inV1= new InputValidation();
		
		if(inV1.isValidInput(firstName) && inV1.isValidInput(lastName) && inV1.isValidEmail(email))
		{
			/*users[0].email = "mj@gmail.com";
			users[0].firstName = "michael";
			users[0].lastName = "jackson";
			users[0].password = "kingofpop09";
			*/
			
			//create a new user using the data
			User user = new User(firstName, lastName, email, password);
			users[index] = user;
			System.out.println("User added!");
			
		}
		else
		{
			if(!(inV1.isValidEmail(email)))
			{
				System.out.println("ERROR: Enter a valid email");
			}
			if(!(inV1.isValidInput(firstName)))
			{
				System.out.println("ERROR: Enter a valid first name");
			}
			if(!(inV1.isValidInput(lastName)))
			{
				System.out.println("ERROR: Enter a valid last name");
			}
		}
	}
}