package uk.ac.aber.dcs.cs12420.aberpizza.data;

/**
 * Drinks class which inherits from SuperItem used to create drinks objects
 * 
 * @author stk4
 * 
 */
public class Drinks extends SuperItem {
	public Drinks() {

	}

	/**
	 * returns Drinks description
	 * 
	 */
	@Override
	public String getDecription() {
		return description;
	}

}
