package uk.ac.aber.dcs.cs12420.aberpizza.tests;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Order;
import uk.ac.aber.dcs.cs12420.aberpizza.data.OrderItem;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Pizza;
import uk.ac.aber.dcs.cs12420.aberpizza.gui.DataManager;
import uk.ac.aber.dcs.cs12420.aberpizza.gui.ItemPanel;
import uk.ac.aber.dcs.cs12420.aberpizza.gui.OrderPanel;

/**
 * Test class written for testing of the methods inside the Order class
 * 
 * @author stk4
 * 
 */
public class OrderTest {

	/**
	 * tests if the set and get customer name methods inside the Order class
	 * works
	 */
	@Test
	public void setAndGetCustomerDescriptionTest() {
		Order order = new Order();
		order.setCustomerName("Stefan Klaus");
		assertEquals("Expected 'Stefan Klaus'", "Stefan Klaus",
				order.getCustomerName());
	}

	/**
	 * tests if the set and get subtotal methods inside the Order class work
	 * also test the addItem method
	 */
	@Test
	public void addItemAndGetSubtotalTest() {
		Order order = new Order();
		Pizza pizza = new Pizza();
		pizza.setDescription("Ham&Cheese");
		pizza.setPrice(new BigDecimal(10.0));

		order.addItem(pizza, 3);

		assertEquals("Expected '30.0'", new BigDecimal("30.0"),
				order.getSubtotal());
	}

	/**
	 * tests the set and get total methods
	 */
	@Test
	public void setAndGetTotalTest() {
		Order order = new Order();
		order.setTotal(new BigDecimal("55.60"));

		assertEquals("Expected '55.60'", new BigDecimal("55.60"),
				order.getTotal());
	}

	/**
	 * tests if the set and get DataManager methods are working
	 */
	@Test
	public void setAndGetDataManager() {
		Order order = new Order();
		ItemPanel itemPanel = new ItemPanel();
		OrderPanel orderPanel = new OrderPanel();
		DataManager dataManager = new DataManager(itemPanel, orderPanel);

		order.setDataManager(dataManager);

		assertEquals("Expected 'dataManager'", dataManager,
				order.getDataManager());
	}

	/**
	 * tests the set and get date methods
	 */
	@Test
	public void setAndGetDateTest() {
		Order order = new Order();
		Date date = new Date();

		order.setDate(date);

		assertEquals("Expected 'date'", date, order.getDate());
	}

	/**
	 * test the set and get Items methods
	 */
	@Test
	public void setAndGetItemsTest() {
		Order order = new Order();
		ArrayList<OrderItem> items = new ArrayList<OrderItem>();

		order.setItems(items);

		assertEquals("Expected 'items'", items, order.getItems());
	}

	/**
	 * test the set and get quantity methods
	 */
	@Test
	public void setAndGetQuantityTest() {
		Order order = new Order();
		int quantity = 3;

		order.setQuantity(quantity);

		assertEquals("Expected '3'", quantity, order.getQuantity());
	}

	/**
	 * tests that the updateItemQuantity works checked that it returns true when
	 * the items are the same and false when the items are not the same
	 */
	@Test
	public void testUpdateItemQuantityTest() {
		Order order = new Order();
		Pizza pizza1 = new Pizza();
		Pizza pizza2 = new Pizza();
		Pizza pizza3 = new Pizza();
		Pizza pizza4 = new Pizza();

		pizza1.setDescription("trueTest");
		pizza1.setPrice(new BigDecimal("5.0"));

		pizza2.setDescription("trueTest");
		pizza2.setPrice(new BigDecimal("5.0"));

		pizza3.setDescription("falseTest");
		pizza3.setPrice(new BigDecimal("3.0"));

		pizza4.setDescription("Test");
		pizza4.setPrice(new BigDecimal("1.0"));

		order.addItem(pizza1, 2);

		// tests if it returns true when items are the same
		assertEquals("Expected 'true'", true,
				order.updateItemQuantity(pizza2, 1));

		// tests if its returns false when items are different
		assertEquals("Expected 'false'", false,
				order.updateItemQuantity(pizza3, 2));

		// tests if its returns false when just one value is different
		assertEquals("Expected 'false'", false,
				order.updateItemQuantity(pizza4, 1));
	}
}
