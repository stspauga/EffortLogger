/*
 * Structure to store data on each individual defect
 * Contributions :
 * Zachary Weber
 */

package application;

public class Defect {
	private int id;
	private String name;
	private boolean status; //Open True, Close False
	private String description;
	private String startStep;
	private String endStep;
	private String category;
	
	public Defect(int id) {
		this.setId(id);
		setName("new-defect-" + Integer.toString(id));
		setStatus(true);
		setDescription("");
		setStartStep(null);
		setEndStep(null);
		setCategory("Not Specified");
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStartStep() {
		return startStep;
	}
	public void setStartStep(String startStep) {
		this.startStep = startStep;
	}
	public String getEndStep() {
		return endStep;
	}
	public void setEndStep(String endStep) {
		this.endStep = endStep;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String toString() {
		return Integer.toString(id) + "." + name; 
	}
}
