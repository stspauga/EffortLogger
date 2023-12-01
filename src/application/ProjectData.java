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
	private ArrayList<EffortLog> effortLogList = new ArrayList<EffortLog>();
	int nextLogId;
	private ArrayList<Defect> defectList = new ArrayList<Defect>();
	int nextDefectId;
	
	
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
	
	// add a new defect to the project's list
	public void addDefect(Defect newDefect) {
		this.defectList.add(newDefect);
		nextDefectId++;
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
	public int getNextDefectId() {
		return nextDefectId;
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
	public ArrayList<Defect> getDefectList() {
		return defectList;
	}
	
	// given an id, return an Effort Log object
	public EffortLog findEffortLog(int id) {
		for (EffortLog log: effortLogList) {
			if (log.getId() == id) {
				return log;
			}
		}
		System.out.println("No log with given id found in project");
		return null;
	}
	// given an id, return an Effort Log object
		public Defect findDefect(int id) {
			for (Defect log: defectList) {
				if (log.getId() == id) {
					return log;
				}
			}
			System.out.println("No defect with given id found in project");
			return null;
		}
	// return a list of defect log names
	public String[] getDefectArr() {
		String[] defects = new String[defectList.size()];
		int i = 0;
		for (Defect log : defectList) {
			defects[i] = log.toString();			
			i++;
		}
		return defects;
	}
	// Deletes all effort logs for a project
	public void deleteEffortLogs() {
		effortLogList.clear();
	}
	public void deleteEffortLog(EffortLog log) {
		System.out.println("!!!Deleting this log!!!");
		effortLogList.remove(effortLogList.indexOf(log));
	}
	// Deletes all defect logs for a project
	public void deleteDefectLogs() {
		defectList.clear();
	}
	public void deleteDefectLog(Defect log) {
		System.out.println("!!!Deleting this Defect!!!");
		defectList.remove(defectList.indexOf(log));
	}
}
