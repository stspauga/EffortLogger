package application;

public class Definition {
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 3de6f5a (Fixed the definitions section)
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
<<<<<<< HEAD
	}

}
=======
	private interface definition_item {
		String PROJ_NAME = "";
		String DETAIL_ONE = "";
		String DETAIL_TWO = "";
		String DETAIL_THREE = "";
		String LIFE_CYCLE = "";
	}
	
	private static definition_item[] definitionItemsArray;
	
	private void searchForProject(String projName) {
		
	}
}
>>>>>>> 5b9bba2 (Created Definitions UI)
=======
	}

}
>>>>>>> 3de6f5a (Fixed the definitions section)
