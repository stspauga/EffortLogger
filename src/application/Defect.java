package application;

public class Defect {
	private int id;
	private String name;
	private boolean status; //Open True, Close False
	private String description;
	private String startStep;
	private String endStep;
	private String category;
	
	public Defect(int id, String startStep) {
		this.id = id;
		name = "new-log-" + Integer.toString(id);
		status = true;
		description = "";
		startStep = null;
		endStep = null;
		category = "Not Specified";
	}
}
