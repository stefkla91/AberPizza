package uk.ac.aber.dcs.cs12420.aberpizza.data;

/**
 * Sides class which inherits from SuperItem used to create Sides Objects
 * 
 * @author stk4
 * 
 */
public class Sides extends SuperItem {
	public Sides() {

	}

	/**
	 * returns the description of the Side
	 * 
	 * @return description - String
	 */
	@Override
	public String getDecription() {
		return description;
	}
}
