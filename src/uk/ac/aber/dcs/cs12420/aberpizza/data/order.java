package uk.ac.aber.dcs.cs12420.aberpizza.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import uk.ac.aber.dcs.cs12420.aberpizza.gui.DataManager;

/**
 * Order class which holds an ArrayList of OrderItems and methods additional
 * data like Customer name for the current order and the quantity of each object
 * in the ArrayList of OrderItems
 * 
 * @author stk4
 * 
 */
public class Order {
	private Date date;
	private String customerName;
	private ArrayList<OrderItem> items;
	private int quantity;
	private DataManager dataManager;
	private BigDecimal total;

	/**
	 * Constructor of the Order class creates an ArrayList of OrderItems - items
	 * sets the String customerName to "Unknown" creates an new Date - date
	 */
	public Order() {
		items = new ArrayList<OrderItem>();
		customerName = "Unknown";
		date = new Date();
		total = new BigDecimal("0.00");
	}

	/**
	 * set's the total for the day
	 * 
	 * @param total
	 *            - BigDecimal
	 */
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	/**
	 * returns the total for this order
	 * 
	 * @return total - BigDecimal
	 */
	public BigDecimal getTotal() {
		return total;
	}

	/**
	 * gets the dataManger for this class
	 * 
	 * @return dataManger
	 */
	public DataManager getDataManager() {
		return dataManager;
	}

	/**
	 * sets the DataManger for this class
	 * 
	 * @param dataManager
	 */
	public void setDataManager(DataManager dataManager) {
		this.dataManager = dataManager;
	}

	/**
	 * gets the date for this order
	 * 
	 * @return date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * sets the date for this Class - used to set the date on the different
	 * orders
	 * 
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * 
	 * @return returns the ArrayList of OrderItems
	 */
	public ArrayList<OrderItem> getItems() {
		return items;
	}

	/**
	 * set the ArrayList of OrderItems
	 * 
	 * @param items
	 */
	public void setItems(ArrayList<OrderItem> items) {
		this.items = items;
	}

	/**
	 * 
	 * @return int the quantity for this order
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * sets the quantity for this order input has to be an int
	 * 
	 * @param quantity
	 *            - int
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * sets the customer name for this order input has to be an String
	 * 
	 * @param name
	 *            - String
	 */
	public void setCustomerName(String name) {
		customerName = name;
	}

	/**
	 * 
	 * @return String customer name for this order, if no name has been set the
	 *         default return will be "Unknown"
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * calls the updateItemQuantity method. If that return false it creates an
	 * new OrderItem and add it to the ArrayList<OrderItem> items
	 * 
	 * @param item
	 *            it has to be an Object that implements this Project Item
	 *            interface
	 * @param quantity
	 *            quantity for object that is going to be added
	 */
	public void addItem(Item item, int quantity) {
		if (!updateItemQuantity(item, quantity)) {
			OrderItem orderItem = new OrderItem();
			orderItem.setItem(item);
			orderItem.setQuantity(quantity);
			items.add(orderItem);
		}
	}

	/**
	 * loops through the ArrayList of OrderItems, and checks if the input-item
	 * already exists inside the list if yes it add 1 to the quantity each time
	 * this method is called
	 * 
	 * @param item
	 *            - the item which it looks for in the ArrayList
	 * @param quantity
	 *            int - quantity of the item you want to add / of the item that
	 *            already exists
	 * 
	 * @return boolean true - when the Item was found
	 * @return boolean false - when the Item was not found in the ArrayList
	 */
	public boolean updateItemQuantity(Item item, int quantity) {
		for (OrderItem i : items) {
			if (i.getItem().getDecription() == item.getDecription()
					&& i.getItem().getPrice().compareTo(item.getPrice()) == 0) {
				i.setQuantity(i.getQuantity() + quantity);
				return true;
			}
		}
		return false;
	}

	/**
	 * returns the subtotal for the current order
	 * 
	 * @return BigDecimal subtotal
	 */
	public BigDecimal getSubtotal() {
		BigDecimal subtotal = new BigDecimal("0.0");
		int qu = 0;

		for (OrderItem item : items) {
			qu = item.getQuantity();
			subtotal = subtotal.add(item.getItem().getPrice()
					.multiply(new BigDecimal(qu)));
		}
		return subtotal;
	}

	/**
	 * - Not Implemented - returns the Discount for the Order
	 * 
	 * @return null
	 */
	public BigDecimal getDiscount() {
		return null;
	}

	/**
	 * - Not Implemented - returns the Receipt for the Order
	 * 
	 * @return null
	 */
	public String getReceipt() {
		return null;
	}
}
