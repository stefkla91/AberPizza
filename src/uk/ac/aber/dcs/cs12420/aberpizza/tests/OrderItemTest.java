package uk.ac.aber.dcs.cs12420.aberpizza.tests;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import org.junit.Test;
import uk.ac.aber.dcs.cs12420.aberpizza.data.OrderItem;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Pizza;

/**
 * Test class where I test the methods of the OrderItem class
 * 
 * @author stk4
 * 
 */
public class OrderItemTest {

	/**
	 * tests the set and get quantity method
	 */
	@Test
	public void setAndGetQuantityTest() {
		OrderItem item = new OrderItem();

		item.setQuantity(2);

		assertEquals("Expected '2'", 2, item.getQuantity());
	}

	/**
	 * test the set and Item methods
	 */
	@Test
	public void setAndGetItemTest() {
		OrderItem item = new OrderItem();
		// Item i = new Item();
		Pizza p = new Pizza();

		item.setItem(p);

		assertEquals("Expected 'p'", p, item.getItem());
	}

	/**
	 * test the getOrderItemTotal method
	 */
	@Test
	public void getOrderItemTotalTest() {
		OrderItem item = new OrderItem();
		Pizza pizza = new Pizza();

		pizza.setPrice(new BigDecimal("10"));
		item.setItem(pizza);
		item.setQuantity(2);

		assertEquals("Expected '20'", new BigDecimal("20"),
				item.getOrderItemTotal());
	}

}
