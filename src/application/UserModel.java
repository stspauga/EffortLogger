package application;

public class UserModel {
	String firstName;
	String lastName;
	String email;
	String password;
	UserModel[] users = new UserModel[7];
	
	UserModel() {
		firstName = "";
		lastName = "";
		email = "";
		password = "";
	}
	public void createTestUser() {
		
		users[0].email = "mj@gmail.com";
		users[0].firstName = "michael";
		users[0].lastName = "jackson";
		users[0].password = "kingofpop09";
		
	}
}
;