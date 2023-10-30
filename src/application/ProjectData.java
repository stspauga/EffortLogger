/* Project Data Object
 * This will also be read from a user's file after authentication in the end product,  
 * 	but for this prototype, it will be empty for new users.
 * This will be saved to the user's file upon exiting to login screen or upon exiting in the end product.
 * Contributions :
 * Zachary Weber
*/
package application;

public class ProjectData {
	// Project Data
	private String projectName; 
	// The following 3 arrays are grouped by their indices
	private String[] lifeCycleStepArr = new String[50];
	private int[] stepEffortCategory = new int[50];
	private int[] stepDeliverable = new int[50];
	// Let us set a temporary cap of 50 effort logs for this prototype
	private EffortLog[] effortLogArr = new EffortLog[50];
	
	
	// Default Constructor for new user demo
	ProjectData() {
		projectName = "Business Project";
		lifeCycleStepArr[0] = "Problem Understanding";
		stepEffortCategory[0] = 1;
		stepDeliverable[0] = 0;
	}
	
	// Constructor to read from file after authentication
	// Not currently implemented in prototype
	ProjectData(String userFileName) {
		// Read from the user's file to initialize project data
	}
	
}
