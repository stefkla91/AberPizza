package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.math.BigDecimal;

/**
 * abstract SuperItem class which implements the Item interface holds all the
 * common methods and fields which all 3 items in this program have
 * 
 * @author stk4
 * 
 */
public abstract class SuperItem implements Item {
	protected BigDecimal price;
	protected String description;

	public SuperItem() {

	}

	/**
	 * returns the price of the item
	 * 
	 * @return price - BigDecimal
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * sets the price for the item
	 * 
	 * @param price
	 *            - BigDecimal
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * returns the description for the item
	 * 
	 * @return description - String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * sets the description for the Item
	 * 
	 * @param description
	 *            - String
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
