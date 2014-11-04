package uk.ac.aber.dcs.cs12420.aberpizza.tests;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import org.junit.Test;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Drinks;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Pizza;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Sides;

/**
 * Test class written for testing if the single methods in Pizza, Sides and
 * Drinks work as they should
 * 
 * @author stk4
 * 
 */
public class SuperItemTest {

	/**
	 * test if the set and get description methods inside the Pizza class work
	 */
	@Test
	public void pizzaSetAndGetDescriptionTest() {
		Pizza pizza = new Pizza();
		pizza.setDescription("HamAndCheese");
		assertEquals("Expected 'HamAndCheese'", "HamAndCheese",
				pizza.getDescription());
	}

	/**
	 * tests if the set and get price methods inside the Pizza class work
	 */
	@Test
	public void pizzaSetAndGetPriceTest() {
		Pizza pizza = new Pizza();
		pizza.setPrice(new BigDecimal(15.99));
		assertEquals("Excepted '15.99", new BigDecimal(15.99), pizza.getPrice());
	}

	/**
	 * tests if the set and get largePrice methods inside the Pizza class work
	 */
	@Test
	public void pizzaSetAndGetLargePriceTest() {
		Pizza pizza = new Pizza();
		pizza.setLargePrice(new BigDecimal(15.99));
		assertEquals("Expected '15.99'", new BigDecimal(15.99),
				pizza.getLargePrice());
	}

	/**
	 * tests if the set and get mediumPrice methods inside the Pizza class work
	 */
	@Test
	public void pizzaSetAndGetMediumPriceTest() {
		Pizza pizza = new Pizza();
		pizza.setMediumPrice(new BigDecimal(12.99));
		assertEquals("Expected '12.99'", new BigDecimal(12.99),
				pizza.getMediumPrice());
	}

	/**
	 * tests if the set and get smallPrice methods inside the Pizza class work
	 */
	@Test
	public void pizzaSetAndGetSmallPriceTest() {
		Pizza pizza = new Pizza();
		pizza.setSmallPrice(new BigDecimal(7.99));
		assertEquals("Expected '7.99", new BigDecimal(7.99),
				pizza.getSmallPrice());
	}

	/**
	 * tests if the set and get description methods inside the Drinks class work
	 */
	@Test
	public void drinksSetAndGetDescriptionTest() {
		Drinks drink = new Drinks();
		drink.setDescription("Coca Cola");
		assertEquals("Expected 'Coca Cola'", "Coca Cola", drink.getDecription());
	}

	/**
	 * tests if the set and get price methods inside the Drinks class work
	 */
	@Test
	public void drinksSetAndGetPriceTest() {
		Drinks drinks = new Drinks();
		drinks.setPrice(new BigDecimal(2.65));
		assertEquals("Expected '2.65'", new BigDecimal(2.65), drinks.getPrice());
	}

	/**
	 * test if the set and get description methods inside the Sides class work
	 */
	@Test
	public void sidesSetAndGetDescriptionTest() {
		Sides side = new Sides();
		side.setDescription("Ceasar Salad");
		assertEquals("Expected 'Ceasar Salad'", "Ceasar Salad",
				side.getDescription());
	}

	/**
	 * test if the set and get price methods inside the Sides class work
	 */
	@Test
	public void sidesSetAndGetPriceTest() {
		Sides side = new Sides();
		side.setPrice(new BigDecimal(5.99));
		assertEquals("Expected '5.99'", new BigDecimal(5.99), side.getPrice());
	}
}
