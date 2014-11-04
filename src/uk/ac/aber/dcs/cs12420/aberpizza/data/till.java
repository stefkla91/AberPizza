package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.beans.PersistenceDelegate;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Till class which holds an ArrayList of Orders holds method like save, load
 * and getting the total for the day
 * 
 * @author stk4
 * 
 */
public class Till {
	private ArrayList<Order> orders;
	private BigDecimal totalForDay;

	/**
	 * Constructor of the Till creates an new ArrayList of Orders
	 */
	public Till() {
		orders = new ArrayList<Order>();
		totalForDay = new BigDecimal("0.00");
	}

	/**
	 * add's the order to the ArrayList of Orders
	 * 
	 * @param order
	 *            - Order object
	 */
	public void addOrder(Order order) {
		orders.add(order);
	}

	/**
	 * returns the ArrayList of Orders
	 * 
	 * @return orders - ArrayList<Order>
	 */
	public ArrayList<Order> getOrders() {
		return orders;
	}

	/**
	 * set the ArrayList of Orders
	 * 
	 * @param orders
	 *            - ArrayList<Order>
	 */
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	/**
	 * calculates the total for all Orders in the ArrayList and returns the
	 * value
	 * 
	 * @return daytotal - BigDecimal
	 */
	public BigDecimal getTotalForDay() {
		BigDecimal daytotal = new BigDecimal("0.0");

		for (Order order : orders) {
			daytotal = daytotal.add(order.getSubtotal());
		}
		return daytotal;
	}

	/**
	 * sets the Total for the day
	 * 
	 * @param totalForDay
	 *            - BigDecimal
	 */
	public void setTotalForDay(BigDecimal totalForDay) {
		this.totalForDay = totalForDay;
	}

	/**
	 * Saves the current till to an XML file
	 * 
	 * @param fill
	 *            - File name of the file you want to save it as
	 * @throws FileNotFoundException
	 */
	public void save(File fill) throws FileNotFoundException {

		FileOutputStream os = new FileOutputStream(fill);
		XMLEncoder encoder = new XMLEncoder(os);
		PersistenceDelegate pd = encoder.getPersistenceDelegate(Integer.class);
		encoder.setPersistenceDelegate(BigDecimal.class, pd);
		encoder.writeObject(this);
		encoder.close();
	}

	/**
	 * loads a till with all orders from an xml file
	 * 
	 * @param fileName
	 *            - String filename of the file to laod
	 * @return till - Till
	 * @throws IOException
	 */
	public Till load(String fileName) throws IOException {
		FileInputStream fis = new FileInputStream(fileName);
		XMLDecoder decoder = new XMLDecoder(fis);
		Till till = (Till) decoder.readObject();
		decoder.close();
		return till;
	}
}
