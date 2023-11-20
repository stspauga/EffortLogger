/* Effort Log Data Object
 * This will also be read from a user's file after authentication in the end product,  
 * For new users, it will not exist until the activity is completed. 
 * This will be saved to the user's file upon exiting to login screen or upon exiting in the end product.
 * Contributions :
 * Zachary Weber
*/
package application;

public class EffortLog {
	/* TO-DO
	 * Add some stuff for What each Effort Log contains :
	 * -Start/End Times
	 * -Date
	 * -Life Cycle Step
	 * -Effort Category and sub-Category
	*/
	
	// HH:MM:SS
	private String startTime;
	private String endTime;
	// YYYY-MM-DD
	private String startDate;
	private String endDate;
	
	private String lifeCycleStep;
	private String effortCategory;
	private String effortSubCategory;
	
	// Default constructor
	EffortLog() {
		startDate = "";
		startTime = "";
		endDate = "";
		endTime = "";
		lifeCycleStep = "";
		effortCategory = "";
		effortSubCategory = "";
	}
	// Constructor to be called from console
	EffortLog(String startDate, String startTime) {
		this.startDate = startDate;
		this.startTime = startTime;
		endDate = "";
		endTime = "";
		lifeCycleStep = "";
		effortCategory = "";
		effortSubCategory = "";
	}
	
	public void print() {
		System.out.println("\nEffort Log :");
		System.out.println("Start Date : " + startDate);
		System.out.println("Start Time : " + startTime);
		System.out.println("End Date : " + endDate);
		System.out.println("End Time : " + endTime);
		System.out.println("Life Cycle Step : " + lifeCycleStep);
		System.out.println("Effort Category : " + effortCategory);
		System.out.println("Effort SubCategory : " + effortSubCategory);
	}
	public void setAll(String startDate, String startTime, String endDate, String endTime, 
					String lifeCycleStep, String effortCategory, String effortSubCategory) {
		if (startDate != "") {setStartDate(startDate);}
		if (startTime != "") {setStartTime(startTime);}
		if (endDate != "") {setEndDate(endDate);}
		if (endTime != "") {setEndTime(endTime);}
		if (lifeCycleStep != "") {setLifeCycleStep(lifeCycleStep);}
		if (effortCategory != "") {setEffortCategory(effortCategory);}
		if (effortSubCategory != "") {setEffortSubCategory(effortSubCategory);}
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getLifeCycleStep() {
		return lifeCycleStep;
	}
	public void setLifeCycleStep(String lifeCycleStep) {
		this.lifeCycleStep = lifeCycleStep;
	}
	public String getEffortCategory() {
		return effortCategory;
	}
	public void setEffortCategory(String effortCategory) {
		this.effortCategory = effortCategory;
	}
	public String getEffortSubCategory() {
		return effortSubCategory;
	}
	public void setEffortSubCategory(String effortSubCategory) {
		this.effortSubCategory = effortSubCategory;
	}
	
}
