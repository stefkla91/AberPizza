package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.math.BigDecimal;

/**
 * Pizza class which inherits from SuperItem used to create Pizza objects
 * 
 * @author stk4
 * 
 */
public class Pizza extends SuperItem {
	private BigDecimal largePrice, mediumPrice, smallPrice;

	public Pizza() {

	}

	/**
	 * return the largePrice value of the Pizza
	 * 
	 * @return largePrice - BigDecimal
	 */
	public BigDecimal getLargePrice() {
		return largePrice;
	}

	/**
	 * set's the largePrice value for the pizza
	 * 
	 * @param largePrice
	 *            - BigDecimal
	 */
	public void setLargePrice(BigDecimal largePrice) {
		this.largePrice = largePrice;
		price = largePrice;
	}

	/**
	 * returns the mediumPrice value of the pizza
	 * 
	 * @return mediumPrice - BigDecimal
	 */
	public BigDecimal getMediumPrice() {
		return mediumPrice;
	}

	/**
	 * set's mediumPrice value for the pizza
	 * 
	 * @param mediumPrice
	 *            - BigDecimal
	 */
	public void setMediumPrice(BigDecimal mediumPrice) {
		this.mediumPrice = mediumPrice;
		price = mediumPrice;
	}

	/**
	 * return the smallPrice value of the pizza
	 * 
	 * @return smallPrice - BigDecimal
	 */
	public BigDecimal getSmallPrice() {
		return smallPrice;
	}

	/**
	 * set's the smallPrice value of the pizza
	 * 
	 * @param smallPrice
	 *            - BigDecimal
	 */
	public void setSmallPrice(BigDecimal smallPrice) {
		this.smallPrice = smallPrice;
		price = smallPrice;
	}

	/**
	 * returns the description of the pizza
	 * 
	 * @return description - String
	 */
	@Override
	public String getDecription() {
		return description;
	}

}
