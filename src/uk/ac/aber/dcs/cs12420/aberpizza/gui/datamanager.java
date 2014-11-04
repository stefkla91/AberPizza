package uk.ac.aber.dcs.cs12420.aberpizza.gui;

import java.beans.XMLDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Drinks;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Order;
import uk.ac.aber.dcs.cs12420.aberpizza.data.OrderItem;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Pizza;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Sides;
import uk.ac.aber.dcs.cs12420.aberpizza.data.Till;
import java.math.BigDecimal;

/**
 * DataManager class which does all the transfer of data and calling of methods
 * between classes
 * 
 * @author stk4
 * 
 */
public class DataManager {
	private OrderPanel orderPanel;
	private ItemPanel itemPanel;
	private Till till;
	private Order order;
	private ArrayList<Pizza> pizzaArray;
	private ArrayList<Pizza> largePizza;
	private ArrayList<Pizza> mediumPizza;
	private ArrayList<Pizza> smallPizza;
	private ArrayList<Sides> sidesArray;
	private ArrayList<Drinks> drinkArray;
	private String orderItem;

	/**
	 * constructor of the DataManager class, takes an ItemPamel and OrderPanel
	 * as parameter to set up relations between them
	 * 
	 * @param itemPanel
	 *            - ItemPanel
	 * @param orderPanel
	 *            - OrderPanel
	 */
	public DataManager(ItemPanel itemPanel, OrderPanel orderPanel) {
		this.orderPanel = orderPanel;
		this.itemPanel = itemPanel;
	}

	/**
	 * calling the startupMenu method in ItemPanel
	 * 
	 * @throws IOException
	 */
	public void loadStandartStartMenu() throws IOException {
		itemPanel.startupMenu();
	}

	/**
	 * add's an item to the "Basket" i orderPanel
	 * 
	 * @param item
	 *            - String name of the item to add
	 */
	public void addItemToOrder(String item) {
		orderPanel.clear();

		String fetchedItem = null;
		for (OrderItem i : order.getItems()) {
			fetchedItem = i.getItem().getDecription() + " : "
					+ i.getItem().getPrice() + " £  Q : " + i.getQuantity();
			orderPanel.addItem(fetchedItem);
		}
	}

	/**
	 * creates an new Order, new Till and calls the clear() and
	 * clearCustomerName() method of the OrderPanel
	 */
	public void newOrder() {
		till = new Till();
		order = new Order();
		orderPanel.clear();
		orderPanel.clearCustomerName();
	}

	/**
	 * calls getChoosenMenu() method from ItemPanel which returns what kind of
	 * menu the user has chosen from, than getting the chosen element out of an
	 * ArrayList inside the DataManager class and adding that to the current
	 * Order
	 * 
	 * @param numb
	 *            - int number of the chosen item inside the ArrayList
	 * @param quant
	 *            - int quantity for the chosen Item
	 * @throws IOException
	 */
	public void addOrder(int numb, int quant) throws IOException {
		orderItem = null;

		if (itemPanel.getChoosenMenu() == "large") {
			int i = itemPanel.getChoosen();
			Pizza tempPizza = new Pizza();
			tempPizza.setDescription(largePizza.get(i).getDecription());
			tempPizza.setLargePrice(largePizza.get(i).getLargePrice());
			order.addItem(tempPizza, quant);
			till.addOrder(order);
			addItemToOrder(orderItem);
		} else if (itemPanel.getChoosenMenu() == "medium") {
			int i = itemPanel.getChoosen();
			Pizza tempPizza = new Pizza();
			tempPizza.setDescription(mediumPizza.get(i).getDecription());
			tempPizza.setLargePrice(mediumPizza.get(i).getMediumPrice());
			order.addItem(tempPizza, quant);
			till.addOrder(order);
			addItemToOrder(orderItem);
		} else if (itemPanel.getChoosenMenu() == "small") {
			int i = itemPanel.getChoosen();
			Pizza tempPizza = new Pizza();
			tempPizza.setDescription(smallPizza.get(i).getDecription());
			tempPizza.setLargePrice(smallPizza.get(i).getSmallPrice());
			order.addItem(tempPizza, quant);
			till.addOrder(order);
			addItemToOrder(orderItem);
		} else if (itemPanel.getChoosenMenu() == "side") {
			int i = itemPanel.getChoosen();
			Sides tempSide = new Sides();
			tempSide.setDescription(sidesArray.get(i).getDecription());
			tempSide.setPrice(sidesArray.get(i).getPrice());
			order.addItem(tempSide, quant);
			till.addOrder(order);
			addItemToOrder(orderItem);
		} else if (itemPanel.getChoosenMenu() == "drink") {
			int i = itemPanel.getChoosen();
			Drinks tempDrink = new Drinks();
			tempDrink.setDescription(drinkArray.get(i).getDecription());
			tempDrink.setPrice(drinkArray.get(i).getPrice());
			order.addItem(tempDrink, quant);
			till.addOrder(order);
			addItemToOrder(orderItem);
		}
	}

	/**
	 * set's the CustomerName for the current Order
	 * 
	 * @param name
	 *            - String
	 */
	public void setCustomerName(String name) {
		order.setCustomerName(name);
	}

	/**
	 * return the size of the ArrayList<OrderItem> in the current order
	 * 
	 * @return int
	 */
	public int checkNumberOfOrderItems() {
		return order.getItems().size();
	}

	/**
	 * save the current till by calling the save() method in Till writes the
	 * current date and time according to ISO 8601 as the title of the .xml
	 * document call methods to calculate the total of the till and than add
	 * that data in the Order class all tills are saved to the Tills folder
	 * 
	 * @throws IOException
	 */
	public void saveTill() throws IOException {
		BigDecimal total = new BigDecimal("0.00");
		total = order.getSubtotal();
		order.setTotal(total);
		String parse = "yyyy-MM-dd_HH-mm-ss";
		SimpleDateFormat dateFormat = new SimpleDateFormat(parse);
		Date date = new Date();
		File fill = new File("Tills", dateFormat.format(date) + ".xml");
		till.save(fill);
	}

	/**
	 * loads the PizzaMenu from the "pizzaMenu.xml" file in the Menu folder and
	 * adds the data to the ArrayList<Pizza> pizzaArray
	 * 
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public void loadPizzaMenu() throws FileNotFoundException {
		pizzaArray = new ArrayList<Pizza>();
		FileInputStream fis = new FileInputStream(new File("Menus",
				"pizzaMenu.xml").toString());
		XMLDecoder decoder = new XMLDecoder(fis);
		pizzaArray = (ArrayList<Pizza>) decoder.readObject();
		decoder.close();
	}

	/**
	 * loads the SideMenu from the "sideMenu.xml"file in the Menu Folder and
	 * adds the data to the ArrayList<Sides> sidesArray
	 * 
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public void loadSidesMenu() throws FileNotFoundException {
		sidesArray = new ArrayList<Sides>();
		FileInputStream fis = new FileInputStream(new File("Menus",
				"sideMenu.xml").toString());
		XMLDecoder decoder = new XMLDecoder(fis);
		sidesArray = (ArrayList<Sides>) decoder.readObject();
		decoder.close();
	}

	/**
	 * loads the DrinkMenu from the "drinkMenu.xml" in the Menu folder and adds
	 * the date to the ArrayList<Drinks> drinkArrays
	 * 
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public void loadDrinkMenu() throws FileNotFoundException {
		drinkArray = new ArrayList<Drinks>();
		FileInputStream fis = new FileInputStream(new File("Menus",
				"drinkMenu.xml").toString());
		XMLDecoder decoder = new XMLDecoder(fis);
		drinkArray = (ArrayList<Drinks>) decoder.readObject();
		decoder.close();
	}

	/**
	 * return the ArrayList<Pizza>
	 * 
	 * @return pizzaArray - ArrayList<Pizza>
	 */
	public ArrayList<Pizza> getPizzaArray() {
		return pizzaArray;
	}

	/**
	 * set's the ArrayList<Pizza>
	 * 
	 * @param pizzaArray
	 *            - ArrayList<Pizza>
	 */
	public void setPizzaArray(ArrayList<Pizza> pizzaArray) {
		this.pizzaArray = pizzaArray;
	}

	/**
	 * 
	 * @return sidesArray - ArrayList<Sides>
	 */
	public ArrayList<Sides> getSidesArray() {
		return sidesArray;
	}

	/**
	 * set's the ArrayList<Sides>
	 * 
	 * @param sidesArray
	 *            - ArrayList<Sides>
	 */
	public void setSidesArray(ArrayList<Sides> sidesArray) {
		this.sidesArray = sidesArray;
	}

	/**
	 * @return drinkArray - ArrayList<Drinks>
	 */
	public ArrayList<Drinks> getDrinkArray() {
		return drinkArray;
	}

	/**
	 * set's the ArrayList<Drinks>
	 * 
	 * @param drinkArray
	 *            - ArrayList<Drinks>
	 */
	public void setDrinkArray(ArrayList<Drinks> drinkArray) {
		this.drinkArray = drinkArray;
	}

	/**
	 * @return pizzaArray.size() - int the size of the pizzaArray ArrayList
	 */
	public int PizzaArraySize() {
		return pizzaArray.size();
	}

	/**
	 * @return sidesArray.size() - int the size of the sidesArray ArrayList
	 */
	public int SideArraySize() {
		return sidesArray.size();
	}

	/**
	 * @return drinkArray.size() - int the size of the drinkArray ArrayList
	 */
	public int DrinkArraySize() {
		return drinkArray.size();
	}

	/**
	 * filters all the large pizzas out of the pizzaArray and put them into a
	 * separate ArrayList
	 * 
	 * @return largePizza - ArrayList<Pizza>
	 */
	public ArrayList<Pizza> getlargePizza() {
		largePizza = new ArrayList<Pizza>();
		for (int i = 0; i < pizzaArray.size(); i++) {
			Pizza tempPizza = new Pizza();
			tempPizza.setDescription(pizzaArray.get(i).getDecription());
			tempPizza.setLargePrice(pizzaArray.get(i).getLargePrice());
			largePizza.add(tempPizza);
		}
		return largePizza;
	}

	/**
	 * filters all the medium pizzas out of the pizzaArray and put them into a
	 * separate ArrayList
	 * 
	 * @return mediumPizza - ArrayList<Pizza>
	 */
	public ArrayList<Pizza> getmediumPizza() {
		mediumPizza = new ArrayList<Pizza>();
		for (int i = 0; i < pizzaArray.size(); i++) {
			Pizza tempPizza = new Pizza();
			tempPizza.setDescription(pizzaArray.get(i).getDecription());
			tempPizza.setMediumPrice(pizzaArray.get(i).getMediumPrice());
			mediumPizza.add(tempPizza);
		}
		return mediumPizza;
	}

	/**
	 * filters all the small pizzas out of the pizzaArray and put them into a
	 * separate ArrayList
	 * 
	 * @return smallPizza - ArrayList<Pizza>
	 */
	public ArrayList<Pizza> getSmallPizza() {
		smallPizza = new ArrayList<Pizza>();
		for (int i = 0; i < pizzaArray.size(); i++) {
			Pizza tempPizza = new Pizza();
			tempPizza.setDescription(pizzaArray.get(i).getDecription());
			tempPizza.setSmallPrice(pizzaArray.get(i).getSmallPrice());
			smallPizza.add(tempPizza);
		}
		return smallPizza;
	}
}
