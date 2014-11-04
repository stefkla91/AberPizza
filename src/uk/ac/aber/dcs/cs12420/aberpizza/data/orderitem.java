package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.math.BigDecimal;

/**
 * OrderItem class represents a link to an particular Item and the quantity for
 * that Item
 * 
 * @author stk4
 * 
 */
public class OrderItem {
	private int quantity;
	private Item item;

	public OrderItem() {

	}

	/**
	 * sets the Quantity of the current Item
	 * 
	 * @param quant
	 *            - int
	 */
	public void setQuantity(int quant) {
		quantity = quant;
	}

	/**
	 * 
	 * @return quantity - int
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * set's the Item for this OrderItem
	 * 
	 * @param item
	 *            - Item
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * @return item - Item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * Multiply the quantity of the item with the price return the Price of the
	 * item
	 * 
	 * @return BigDecimal
	 */
	public BigDecimal getOrderItemTotal() {
		return item.getPrice().multiply(new BigDecimal(quantity));
	}

}
