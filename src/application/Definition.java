package application;

public class Definition {
	String PROJ_NAME;
	String DETAILS;
	String LIFE_CYCLE;
   
    Definition setDefinitionItem(String proj_name, String details, String life_cycle) {
    	this.PROJ_NAME = proj_name;
    	this.DETAILS = details;
    	this.LIFE_CYCLE = life_cycle;
    	return this;
    }
    
    public String getPROJ_NAME() {
        return PROJ_NAME;
    }
    
    public String getDETAILS() {
    	return DETAILS;
    }

	public String getLIFE_CYCLE() {
		return LIFE_CYCLE;
	}

}

