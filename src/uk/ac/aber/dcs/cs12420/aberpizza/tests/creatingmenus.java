package uk.ac.aber.dcs.cs12420.aberpizza.tests;

import java.beans.PersistenceDelegate;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.junit.Test;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Drinks;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Pizza;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Sides;

/**
 * Class written in JUnit where the menus uses in the program are created. They
 * can also be added easy by adding/removing a few lines of code. Save the
 * Menu's as XML files to the "Menus" folder
 * 
 * @author stk4
 * 
 */
public class CreatingMenus {

	/**
	 * Creates the Pizza Menu and saves it gives every Pizza a large, medium and
	 * small price
	 * 
	 * @throws IOException
	 */
	@Test
	public void pizzaMenu() throws IOException {
		ArrayList<Pizza> pizza = new ArrayList<Pizza>();

		Pizza pizza1 = new Pizza();
		pizza1.setDescription("Firenze");
		pizza1.setLargePrice(new BigDecimal("16.99"));
		pizza1.setMediumPrice(new BigDecimal("14.99"));
		pizza1.setSmallPrice(new BigDecimal("12.99"));

		Pizza pizza2 = new Pizza();
		pizza2.setDescription("Florentine");
		pizza2.setLargePrice(new BigDecimal("16.99"));
		pizza2.setMediumPrice(new BigDecimal("14.99"));
		pizza2.setSmallPrice(new BigDecimal("12.99"));

		Pizza pizza3 = new Pizza();
		pizza3.setDescription("Rustica");
		pizza3.setLargePrice(new BigDecimal("16.99"));
		pizza3.setMediumPrice(new BigDecimal("14.99"));
		pizza3.setSmallPrice(new BigDecimal("12.99"));

		Pizza pizza4 = new Pizza();
		pizza4.setDescription("Pepperoni");
		pizza4.setLargePrice(new BigDecimal("16.99"));
		pizza4.setMediumPrice(new BigDecimal("14.99"));
		pizza4.setSmallPrice(new BigDecimal("12.99"));

		Pizza pizza5 = new Pizza();
		pizza5.setDescription("Ham & Pineapple");
		pizza5.setLargePrice(new BigDecimal("16.99"));
		pizza5.setMediumPrice(new BigDecimal("14.99"));
		pizza5.setSmallPrice(new BigDecimal("12.99"));

		Pizza pizza6 = new Pizza();
		pizza6.setDescription("Tuna Delight");
		pizza6.setLargePrice(new BigDecimal("16.99"));
		pizza6.setMediumPrice(new BigDecimal("14.99"));
		pizza6.setSmallPrice(new BigDecimal("12.99"));

		Pizza pizza7 = new Pizza();
		pizza7.setDescription("New Yorker");
		pizza7.setLargePrice(new BigDecimal("16.99"));
		pizza7.setMediumPrice(new BigDecimal("14.99"));
		pizza7.setSmallPrice(new BigDecimal("12.99"));

		Pizza pizza8 = new Pizza();
		pizza8.setDescription("Cheese & Tomato");
		pizza8.setLargePrice(new BigDecimal("11.99"));
		pizza8.setMediumPrice(new BigDecimal("9.99"));
		pizza8.setSmallPrice(new BigDecimal("7.99"));

		pizza.add(pizza1);
		pizza.add(pizza2);
		pizza.add(pizza3);
		pizza.add(pizza4);
		pizza.add(pizza5);
		pizza.add(pizza6);
		pizza.add(pizza7);
		pizza.add(pizza8);

		FileOutputStream os = new FileOutputStream(new File("Menus",
				"pizzaMenu.xml").toString());
		XMLEncoder encoder = new XMLEncoder(os);
		PersistenceDelegate pd = encoder.getPersistenceDelegate(Integer.class);
		encoder.setPersistenceDelegate(BigDecimal.class, pd);
		encoder.writeObject(pizza);
		encoder.close();
	}

	/**
	 * Creates the Sides Menu and saves it
	 * 
	 * @throws IOException
	 */
	@Test
	public void sideMenu() throws IOException {
		ArrayList<Sides> sides = new ArrayList<Sides>();

		Sides sides1 = new Sides();
		sides1.setDescription("Chicken Wings");
		sides1.setPrice(new BigDecimal("4.49"));

		Sides sides2 = new Sides();
		sides2.setDescription("Boneless Ribs");
		sides2.setPrice(new BigDecimal("4.99"));

		Sides sides3 = new Sides();
		sides3.setDescription("Potato Wedges");
		sides3.setPrice(new BigDecimal("3.49"));

		Sides sides4 = new Sides();
		sides4.setDescription("Garlic Bread");
		sides4.setPrice(new BigDecimal("1.50"));

		Sides sides5 = new Sides();
		sides5.setDescription("Fries");
		sides5.setPrice(new BigDecimal("1.45"));

		Sides sides6 = new Sides();
		sides6.setDescription("ColeSlaw");
		sides6.setPrice(new BigDecimal("2.30"));

		Sides sides7 = new Sides();
		sides7.setDescription("Ceasar Salad");
		sides7.setPrice(new BigDecimal("2.85"));

		Sides sides8 = new Sides();
		sides8.setDescription("Dips");
		sides8.setPrice(new BigDecimal("1.29"));

		sides.add(sides1);
		sides.add(sides2);
		sides.add(sides3);
		sides.add(sides4);
		sides.add(sides5);
		sides.add(sides6);
		sides.add(sides7);
		sides.add(sides8);

		FileOutputStream os = new FileOutputStream(new File("Menus",
				"sideMenu.xml").toString());
		XMLEncoder encoder = new XMLEncoder(os);
		PersistenceDelegate pd = encoder.getPersistenceDelegate(Integer.class);
		encoder.setPersistenceDelegate(BigDecimal.class, pd);
		encoder.writeObject(sides);
		encoder.close();
	}

	/**
	 * Creates the Drinks menu and saves it
	 * 
	 * @throws IOException
	 */
	@Test
	public void drinkMenu() throws IOException {
		ArrayList<Drinks> drink = new ArrayList<Drinks>();

		Drinks drink1 = new Drinks();
		drink1.setDescription("Coca Cola - 1.25ltr");
		drink1.setPrice(new BigDecimal("1.99"));

		Drinks drink2 = new Drinks();
		drink2.setDescription("Coca Cola Zero - 1.25ltr");
		drink2.setPrice(new BigDecimal("1.99"));

		Drinks drink3 = new Drinks();
		drink3.setDescription("Diet Coca Cola - 1.25ltr");
		drink3.setPrice(new BigDecimal("1.99"));

		Drinks drink4 = new Drinks();
		drink4.setDescription("Fanta - 1.25ltr");
		drink4.setPrice(new BigDecimal("1.99"));

		Drinks drink5 = new Drinks();
		drink5.setDescription("Sprite - 1.25ltr");
		drink5.setPrice(new BigDecimal("1.99"));

		Drinks drink6 = new Drinks();
		drink6.setDescription("Orange Juice - 1ltr");
		drink6.setPrice(new BigDecimal("1.50"));

		Drinks drink7 = new Drinks();
		drink7.setDescription("Lemonade - 1.25ltr");
		drink7.setPrice(new BigDecimal("1.50"));

		Drinks drink8 = new Drinks();
		drink8.setDescription("Water - 1.25ltr");
		drink8.setPrice(new BigDecimal("1.50"));

		drink.add(drink1);
		drink.add(drink2);
		drink.add(drink3);
		drink.add(drink4);
		drink.add(drink5);
		drink.add(drink6);
		drink.add(drink7);
		drink.add(drink8);

		FileOutputStream os = new FileOutputStream(new File("Menus",
				"drinkMenu.xml").toString());
		XMLEncoder encoder = new XMLEncoder(os);
		PersistenceDelegate pd = encoder.getPersistenceDelegate(Integer.class);
		encoder.setPersistenceDelegate(BigDecimal.class, pd);
		encoder.writeObject(drink);
		encoder.close();
	}
}
