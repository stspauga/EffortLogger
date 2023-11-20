/* Project Data Object
 * This will also be read from a user's file after authentication in the end product,  
 * 	but for this prototype, it will be empty for new users.
 * This will be saved to the user's file upon exiting to login screen or upon exiting in the end product.
 * Contributions :
 * Zachary Weber
*/
package application;

import java.util.ArrayList;

public class ProjectData {
	// Project Data
	private String projectName; 
	// The following 3 arrays are grouped by their indices
	private String[] lifeCycleStepArr = new String[50];
	private int[] stepEffortCategory = new int[50];
	private int[] stepDeliverable = new int[50];
	// Let us set a temporary cap of 50 effort logs for this prototype
	private ArrayList<EffortLog> effortLogList = new ArrayList<EffortLog>();
	int nextLogId;
	
	
	
	// Default Constructor for new user demo
	ProjectData() {
		projectName = "Business Project";
		lifeCycleStepArr[0] = "Problem Understanding";
		stepEffortCategory[0] = 1;
		stepDeliverable[0] = 0;
		nextLogId = 0;		
	}
	
	// Constructor to read from file after authentication
	// Not currently implemented in prototype
	ProjectData(String userFileName) {
		// Read from the user's file to initialize project data
	}
	
	// add a new effort log to the project's list
	public void addLog(EffortLog newLog) {
		this.effortLogList.add(newLog);
		nextLogId++;
	}
	
	public boolean printLogs() {
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Printing all _" + effortLogList.size() + "_ logs in " + projectName + " : ");
		for(EffortLog i : effortLogList) {
			i.print();
		}
		System.out.println("~~~~~~End of Print~~~~~~");
		return true;
	}
	
	// Get Set methods
	public String getName() {
		return projectName;
	}
	public void setName(String name) {
		projectName = name;
	}
	public int getNextLogId() {
		return nextLogId;
	}
	public void setNextLogId(int nextId) {
		this.nextLogId = nextId;
	}
	public String[] getLifeCycleArr() {
		return lifeCycleStepArr;
	}
	public int[] getStepEffortCategory() {
		return stepEffortCategory;
	}
	public ArrayList<EffortLog> getEffortLogList() {
		return effortLogList;
	}
}
