/* Effort Categories Data Object
 * This will also be read from a user's file after authentication in the end product,  
 * 	but for this prototype, it will be pre-set for new users.
 * This will be saved to the user's file upon exiting to login screen or upon exiting in the end product.
 * Contributions :
 * Zachary Weber
*/
package application;

public class EffortCategoryData {
	// Effort Category Data
	public String[] effortCategories;
	public String[] plans;
	public String[] deliverables;
	public String[] interruptions;
	public String[] defectCategories;
	/*
	 * Need to reformat structure into something more like a matrix
	 * { EffortCategories on the first row
	 * individual selections based on the column going down
	 */
	
	
	// Default Constructor for preset data
	// Default for new Users
	EffortCategoryData() {
		effortCategories = new String[] {"Plans", "Deliverables", "Interruptions", "Defects", "Others"};
		plans = new String[] 
				{"Project", "Risk Management", "Conceptual Design", "Detailed Design", 
				"Implementation", "", "", "", "", ""};
		deliverables = new String[] 
				{"Conceptual Design","Detailed design","Test Cases","Solution","Reflection",
				"Outline","Draft","Report","User Defined","Other"};
		interruptions = new String[] 
				{"Break","Phone","Teammate","Visitor","Other","","","","",""};
		defectCategories = new String[] 
				{"Not Specified","10 Documentation","20 Syntax","30 Build, Package","40 Assignment",
				"50 Interface","60 Checking","70 Data","80 Function","90 System",
				"100 Environment","","","",""};
	}
	
	
	// Specialized Constructor for edited data from returning users
	EffortCategoryData(String userFileName) {
		// Read from userFile to initialize data
	}
}
