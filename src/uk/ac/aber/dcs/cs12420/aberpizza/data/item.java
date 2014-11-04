package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.math.BigDecimal;

/**
 * Item interface which gives the 4 basic methods all Items in the Menu have
 * 
 * @author stk4
 * 
 */
public interface Item {
	public BigDecimal getPrice();

	public void setPrice(BigDecimal price);

	public String getDecription();

	public void setDescription(String description);
}
