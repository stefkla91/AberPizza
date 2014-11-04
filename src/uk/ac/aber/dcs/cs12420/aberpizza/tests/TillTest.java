package uk.ac.aber.dcs.cs12420.aberpizza.tests;

import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.junit.Test;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Drinks;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Order;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Pizza;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Sides;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Till;

/**
 * test class that checks the core methods of the Till class
 * 
 * @author stk4
 * 
 */
public class TillTest {

	/**
	 * tests if the add order and get total forday methods are working
	 */
	@Test
	public void addOrderAndGettotalfordayTest() {
		Till till = new Till();
		Order order1 = new Order();
		Order order2 = new Order();
		Order order3 = new Order();

		Drinks drink = new Drinks();
		drink.setDescription("Coca Cola");
		drink.setPrice(new BigDecimal(5.0));

		Pizza pizza = new Pizza();
		pizza.setDescription("Ham&Cheese");
		pizza.setPrice(new BigDecimal(10.0));

		Sides side = new Sides();
		side.setDescription("Ceasar Salad");
		side.setPrice(new BigDecimal(6.0));

		order1.addItem(side, 3);
		order2.addItem(pizza, 3);
		order3.addItem(drink, 1);

		till.addOrder(order1);
		till.addOrder(order2);
		till.addOrder(order3);

		assertEquals("Expected '53.0'", new BigDecimal("53.0"),
				till.getTotalForDay());

	}

	/**
	 * test if the save and load till methods are working. Note: the work but it
	 * still fails the test as I can't figure out how to test it the right way
	 */
	@Test
	public void testSaveAndLoad() {
		Till till = new Till();
		Till newTill = null;
		Order order1 = new Order();
		Order order2 = new Order();

		Drinks drink = new Drinks();
		drink.setDescription("Cola");
		drink.setPrice(new BigDecimal("10.0"));

		Pizza pizza = new Pizza();
		pizza.setDescription("Ham&Cheese");
		pizza.setPrice(new BigDecimal("15.0"));

		order2.addItem(pizza, 2);
		order1.addItem(drink, 3);
		till.addOrder(order1);
		till.addOrder(order2);

		try {
			File file = new File("tillTest.xml");
			till.save(file);
		} catch (IOException e) {
			e.printStackTrace();
			fail("Could not save till to file.");
		}
		try {
			newTill = till.load("tillTest.xml");
		} catch (IOException e) {
			e.printStackTrace();
			fail("Could not load till from file");
		}
		if (!till.equals(newTill)) {
			fail("Expected till to be equalt to newTill.");
		}
	}

	/**
	 * tests that the set and get ArrayList<Order> methods work
	 */
	@Test
	public void setAndGetOrdersTest() {
		Till till = new Till();
		Order order1 = new Order();
		Order order2 = new Order();

		ArrayList<Order> orders = new ArrayList<Order>();
		orders.add(order1);
		orders.add(order2);

		till.setOrders(orders);

		assertEquals("Expecteds 'orders'", orders, till.getOrders());
	}
}
